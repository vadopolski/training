package leetcode.intersections

object Solution {
  def intervalIntersection(A: Array[Array[Int]],
                           B: Array[Array[Int]]): Array[Array[Int]] =
    (for {
      _a <- A
      _b <- B
    } yield
      (_a, _b) match {
        case (a, b) if a(0) >= b(0) && a(1) <= b(1) => a
        case (a, b) if a(0) < b(0) && a(1) > b(1) => b
        case (a, b) if a(0) > b(0) && a(0) <= b(1) && a(1) >= b(1) => Array(a(0), b(1))
        case (a, b) if a(0) < b(0) && a(1) >= b(0) && a(1) <= b(1) => Array(b(0), a(1))
        case (_, _) => Array.emptyIntArray

      }).filter( _ != Array.emptyIntArray)

  def main(args: Array[String]): Unit = {
    println(
      intervalIntersection(
        Array(Array(0, 2), Array(5, 10), Array(13, 23), Array(24, 25)),
        Array(Array(1, 5), Array(8, 12), Array(15, 24), Array(25, 26))
      ).map(_.toList).toList
    )

  }
}
