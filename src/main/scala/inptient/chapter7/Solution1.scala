package inptient.chapter7
import java.util.concurrent.Executors

import cats.effect.IO

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Solution1 {

  def main(args: Array[String]): Unit = {
    for {
      resA <- Future { Thread.sleep(1000); println(Thread.currentThread().getName);  2 }
      resB <- Future { Thread.sleep(1000); println(Thread.currentThread().getName); 40 }
    } yield ( println(Thread.currentThread().getName))
  }
}