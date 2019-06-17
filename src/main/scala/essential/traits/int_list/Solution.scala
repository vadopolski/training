package essential.traits.int_list

sealed trait IntList {
  def length (): Int = this match {
    case End => 0
    case Pair(head, tail) =>
  }
}
case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

class Solution {
  val example = Pair(1, Pair(2, Pair(3, End)))

  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(End.length == 0)


}
