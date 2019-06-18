package essential.traits.int_list

sealed trait IntList {
  def length (): Int = this match {
    case End => 0
    case Pair(_, tail) => tail.length + 1
  }

  def double (): IntList = this match {
    case End => End
    case Pair(head, tail) => Pair(head*2, tail.double())
  }
}
case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

object Solution {

  def main(args: Array[String]): Unit = {
    println("Test")

    val example = Pair(1, Pair(2, Pair(3, End)))

    assert(example.length == 3)
    assert(example.tail.length == 2)
    assert(End.length == 0)

    assert(example.double == Pair(2, Pair(4, Pair(6, End))))
    assert(example.tail.double == Pair(4, Pair(6, End)))
    assert(End.double == End)
  }
}
