import java.time.Instant

import cats.effect.{ExitCode, IO, IOApp, Timer}
import cats.effect.concurrent.{Deferred, MVar}

import scala.concurrent.duration._
import cats.implicits._

object Robot extends IOApp {

  def left(name: String, mvar: MVar[IO, String], idx: Int = 0): IO[Nothing] =
    for {
      _    <- Timer[IO].sleep(1.1 second)
      _    <- IO(println(s"step $name $idx"))
      _    <- mvar.put(name)
      _    <- Timer[IO].sleep(1.1 second)
      res  <- left(name, mvar, idx + 1)
    } yield res

  def right(name: String, mvar: MVar[IO, String], idx: Int = 0): IO[Nothing] =
    for {
      _      <- Timer[IO].sleep(1.8 second)
      _      <- IO(println(s"step $name $idx"))
      pinger <- mvar.take
      _      <- Timer[IO].sleep(1.8 second)
      res    <- right(name, mvar, idx + 1)
    } yield res

  val process: IO[Unit] = for {
    x  <- MVar[IO].empty[String]
    left        <- left("Left", x).start
    right       <- right("Right", x).start
    _           <- Timer[IO].sleep(5 minutes)
  } yield ()

  def run(args: List[String]): IO[ExitCode] = process as ExitCode.Success
}