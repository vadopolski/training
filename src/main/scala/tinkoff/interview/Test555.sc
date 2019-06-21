import cats.effect.concurrent.{MVar, Ref}
import cats.effect.{ExitCode, IO, IOApp, Timer}
import cats.implicits._

import scala.concurrent.duration._

object Robot extends IOApp {

  def left(name: String, mvar: MVar[IO, Int], idx: Int = 0) =
    for {
      _ <- IO(println(s"step $name $idx"))
      _ <- mvar.put(idx)
      _ <- Timer[IO].sleep(1.1.second)
      res <- if (idx == 10) IO.never else left(name, mvar, idx + 1)
    } yield res

  def right(name: String,
            mvar: MVar[IO, Int],
            result: Ref[IO, List[String]],
            stop: MVar[IO, Unit],
            idx: Int = 0) =
    for {
      _ <- IO(println(s"step $name $idx"))
      leftIdx <- mvar.take
      _ <- result.update(l => s"($leftIdx == $idx)" :: l)
      _ <- Timer[IO].sleep(1.8.second)
      res <- if (idx == 10) stop.put(())
      else right(name, mvar, result, stop, idx + 1)
    } yield res

  val process = for {
    x <- MVar[IO].empty[Int]
    stop <- MVar[IO].empty[Unit]
    result <- Ref[IO].of(List.empty[String])
    left <- left("Left", x).start
    right <- right("Right", x, result, stop).start
    _ <- stop.take
    r <- result.get
    _ <- IO(println(r.reverse.mkString(", ")))
  } yield ()

  def run(args: List[String]) = process as ExitCode.Success
}