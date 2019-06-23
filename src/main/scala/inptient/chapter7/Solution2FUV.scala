package inptient.chapter7
import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global

object Solution2FUV {
  def doInOrder[T, U, V](f: T => Future[U], g: U => Future[V]): T => Future[V] =
    t => f(t).flatMap(u => g(u))


//  def doInOrder2[T, U, V](list : List[T => Future[T]]): T => Future[V] = list.map(f => )
}