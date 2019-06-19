package essential.sequencing.generic_list

final case class End[A]() extends LinkedList[A]
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

case class Success[A](result: A) extends Result[A]
case class Failure[A](reason: String) extends Result[A]

sealed trait Result[A]

sealed trait LinkedList[A] {
  def apply(i: Int): Result[A] = this match {
    case Pair(h, _) if i == 0 => Success(h)
    case Pair(_, t) => t(i - 1)
    case End() => Failure("Index out of bounds")
  }

  def length: Int = this match {
    case End() => 0
    case Pair(_, t) => 1 + t.length
  }

  //  def contains(v: A): Boolean = this match {
  //    case End()                => false
  //    case Pair(h, _) if h == v => true
  //    case Pair(_, t)           => t.contains(v)
  //  }
}

object Solution {
  def main(args: Array[String]): Unit = {

    //    val example = Pair(1, Pair(2, Pair(3, End())))
    //    assert(example(0) == Success(1))
    //    assert(example(1) == Success(2))
    //    assert(example(2) == Success(3))
    //    assert(example(3) == Failure("Index out of bounds"))

    val example = Pair(1, Pair(2, Pair(3, End())))
    assert(example.length == 3)
    assert(example.tail.length == 2)
    assert(End().length == 0)

    //    val example = Pair(1, Pair(2, Pair(3, End())))
    //    assert(example.contains(3) == true)
    //    assert(example.contains(4) == false)
    //    assert(End().contains(0) == false)

    println("Vasja".updated(0, 2))
  }
}
