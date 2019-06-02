package leetcode.contest138

object SolutionFirst {

  def heightChecker(heights: Array[Int]): Int = {
    def go(heights: Array[Int], sorted: Array[Int], acc: Int): Int = (heights, sorted) match {
      case _ if heights.length == 0 => acc
      case _ if heights.head == sorted.head => go(heights.tail, sorted.tail, acc)
      case _ if heights.head != sorted.head => go(heights.tail, sorted.tail, acc + 1)
    }

    go(heights, heights.sorted, 0)
  }

  def main(args: Array[String]): Unit = {
    println(heightChecker(Array(1,1,4,2,1,3)))
  }
}