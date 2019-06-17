package scala_concurency.future

import java.io._

import org.apache.commons.io.FileUtils._

import scala.collection.convert.decorateAsScala._
import scala.concurrent.Future
import scala.io.Source
import scala.concurrent.ExecutionContext.Implicits.global

object Solution {
  def main(args: Array[String]): Unit = {
    val netiquetteUrl = "http://www.ietf.org/rfc/rfc1855.txt"
    val netiquette = Future { Source.fromURL(netiquetteUrl).mkString }
    val urlSpecUrl = "http://www.w3.org/Addressing/URL/url-spec.txt"
    val urlSpec = Future { Source.fromURL(urlSpecUrl).mkString }
    val answer = for {
      nettext <- Future { Source.fromURL(netiquetteUrl).mkString }
      urltext <- Future { Source.fromURL(urlSpecUrl).mkString }
    } yield {
      "First, read this: " + nettext + ". Now, try this: " + urltext
    }

    Thread.sleep(3000)
    answer foreach (contents => {
      println(" test " + contents)
    })
  }
}
