package concurrency.future

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.io.Source
import scala.concurrent.duration._



class Solution {

}

object FuturesCallbacks extends App {
  def getUrlSpec(): Future[List[String]] = Future {
      val url = "http://www.w3.org/Addressing/URL/url-spec.txt"
      val f = Source.fromURL(url)
      try f.getLines.toList
      finally f.close()
    }
  val urlSpec: Future[List[String]] = getUrlSpec()

  def find(lines: List[String], keyword: String): String =
    lines.zipWithIndex collect {
      case (line, n) if line.contains(keyword) => (n, line)
    } mkString("\n")

  val res: List[String] = Await.result(urlSpec, 120.seconds)

  println(find(res, "telnet"))

//  urlSpec foreach {
//    case lines => println(find(lines, "telnet"))
//  }
//  println("callback registered, continuing with other work")
//  Thread.sleep(2000)
}