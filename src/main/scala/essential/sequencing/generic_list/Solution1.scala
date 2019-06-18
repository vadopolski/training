package essential.sequencing.generic_list


trait Tree[A]
case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]
case class Leaf[A](value: A) extends Tree[A]


object Solution1 {

  def main(args: Array[String]): Unit = {

    val tree: Tree[String] =
      Node(Node(Leaf("To"), Leaf("iterate")),
           Node(Node(Leaf("is"), Leaf("human,")),
                Node(Leaf("to"), Node(Leaf("recurse"),
                         Leaf("divine")))))
  }


}