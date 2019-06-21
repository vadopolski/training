package essential.sequencing.generic_list

final case class End[A]() extends LinkedList[A]
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

case class Success[A](result: A) extends Result[A]
case class Failure[A](reason: String) extends Result[A]

sealed trait Result[A]

sealed trait LinkedList[A] {
  def fold[B](end: B, f: (A, B) => B): B =
    this match {
      case End()        => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }

  def apply(i: Int): Result[A] = this match {
    case Pair(h, _) if i == 0 => Success(h)
    case Pair(_, t)           => t(i - 1)
    case End()                => Failure("Index out of bounds")
  }

  def length: Int = fold[Int](0, (_, t) => 1 + t)

  def contains(v: A): Boolean =
    fold[Boolean](false, (h, t) => { if (h == v) true else t })
}

object Solution {
  def main(args: Array[String]): Unit = {
    val example = Pair(1, Pair(2, Pair(3, End())))

    assert(example(0) == Success(1))
    assert(example(1) == Success(2))
    assert(example(2) == Success(3))
    assert(example(3) == Failure("Index out of bounds"))

    assert(example.length == 3)
    assert(example.tail.length == 2)
    assert(End().length == 0)

    assert(example.contains(3))
    assert(!example.contains(4))
    assert(!End().contains(0))

    println("Vasja".updated(0, 2))
  }
}
