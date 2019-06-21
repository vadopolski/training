import scala.concurrent.Future

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

val a = Future { Thread.sleep(200); 5 / 0 }
val b = Future { Thread.sleep(200); 5 }
val c = Future { Thread.sleep(200); 5 / 0 }
val d = Future { Thread.sleep(200); 5 }

val list: Seq[Future[Int]] = Seq(a, b, c, d)

// 0
//list.foldLeft((Seq[Future[Int]], Seq[Future[Int]])) {
//    (acc, el) => {
////      el.onComplete
//      acc
//    }
//  }

var success: Seq[Future[Int]] = Seq()
var failure: Seq[Future[Int]] = Seq()

list.foreach(
  f => f.onComplete {
      case Success(v)     => success = success :+ f
      case Failure(e)     => failure = failure :+ f
    }
  )

success
failure
//list.foldLeft()(f => {
//  f match {
//    case Success =
//  }
//})

//val ab: Future[(Int, Int)] = for {
//  resA <- a
//  resB <- b
//} yield ( resA, resB)
//
//a
//b
//ab
//
//ab.onComplete{
//    case Failure(exception) => println("Fail Test")
//    case Success(value) => println(s"Succes $value")
//}

//val ab1: Future[(Int, Int)] = for {
//  resA <- Future { Thread.sleep(200); 5/0 }
//  resB <- resA match {
//    case Success(value) => value
//    case Failure => Future { Thread.sleep(200); 5 }
//  }
//} yield ( resA, resB)
//a.onComplete{
//  case Failure(exception) => println("Fail")
//  case Success(value) => println(s"Succes $value")
//}
//
//Thread.sleep(3000)
//
//a
//
//a.onComplete{
//  case Failure(exception) => println("Fail Test")
//  case Success(value) => println(s"Succes $value")
//}


