package tinkoff.interview

object Solution extends App {

  val test = List(1, -5, 6, -8, 10, -15)

  println(test.foldLeft((0, 0))((acc, el) => {
    if (el > 0) (acc._1 + el, acc._2 + 0) else { (acc._1, acc._2 + el) }
  }))

}
