import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

val a = Future {
  Thread.sleep(200); 5 / 0
}
val b = Future {
  Thread.sleep(200); 5
}
val c = Future {
  Thread.sleep(200); 5 / 0
}
val d = Future {
  Thread.sleep(200); 7
}

val sequence = Seq(a, b, c, d)

var succesSeq: Seq[Future[Int]] = Seq()
var failureSeq: Seq[Future[Int]] = Seq()

sequence.foreach(
  f => f.onComplete {
    case Success(v) => succesSeq = succesSeq :+ f
    case Failure(e) => failureSeq = failureSeq :+ f
  })


succesSeq
failureSeq

