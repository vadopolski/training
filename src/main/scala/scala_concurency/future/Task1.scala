package scala_concurency.future
import scala.concurrent.{Future, Promise}
import scala.io.Source
import scala.concurrent.ExecutionContext.Implicits.global
import java.util._

object Task1 {
  private val timer = new Timer(true)


  def timeout(t: Long): Future[Unit] = {
    val p = Promise[Unit]
    timer.schedule(new TimerTask {
      def run() = {p success ()
        timer.cancel()
      }
    }, t)
    p.future
  }

//  def main(args: Array[String]): Unit = {
//    val netiquetteUrl = "http://www.ietf.org/rfc/rfc1855.txt"
//    val netiquette = Future { Source.fromURL(netiquetteUrl).mkString }
//
//    timeout(1000) foreach { case _ => println("Timed out!") }
//    Thread.sleep(5000)
//
//    val f = timeout(1000).map(_ => "timeout!") or Future {
//      Thread.sleep(999)
//      "work completed!"
//    }
//  }

}
