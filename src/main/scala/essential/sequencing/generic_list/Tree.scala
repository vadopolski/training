package essential.sequencing.generic_list

final case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]
final case class Leaf[A](value: A) extends Tree[A]

sealed trait Tree[A] {
//  def fold[B](end: B, f: (A, B) => B): B =
//    this match {
//      case Leaf(v)  => end
//      case Node(l, r) => f(l.fold(end, f), r.fold(end, f))
//    }
//
//  def treeToString:String = fold[String]("", (l, r) => l + r)
}

object SolutionTree {
  def main(args: Array[String]): Unit = {

    val tree: Tree[String] =
      Node(
        Node(Leaf("To"), Leaf("iterate")),
        Node(
          Node(Leaf("is"), Leaf("human,")),
          Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))
        )
      )
  }
}
