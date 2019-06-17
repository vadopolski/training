import java.util.concurrent.CountDownLatch

import scala.concurrent.Future
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

val a = Future.successful(1)
val b = Future.failed[Int](new RuntimeException("second"))
val c = Future.successful(3)
val d = Future.failed[Int](new RuntimeException("fourth"))

val futures = Seq(a, b, c, d)

val recoverableFutures = futures.map(_.map(Right[Throwable, Int]).recover {
  case e => Left[Throwable, Int](e)
})

val result = Future.sequence(recoverableFutures).map { fs =>
  (fs.collect {
    case Right(value) => value
  }, fs.collect {
    case Left(ex) => ex
  })
}

val countDownLatch = new CountDownLatch(1)

result.onComplete {
  case Success((success, failures)) => println(s"Success: $success, Failures: $failures"); countDownLatch.countDown()
  case Failure(ex) => ex.printStackTrace(); countDownLatch.countDown()
}

countDownLatch.await()