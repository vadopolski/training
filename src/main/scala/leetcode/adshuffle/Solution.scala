package leetcode.adshuffle

object Solution {
  def getNewPosition(el: Int, A: Array[Int]): Int = {
    A.map(_ - el)
      .zipWithIndex
      .filter(_._1 < 0)
      .maxBy(_._1)
      ._2
  }

  def advantageCount(A: Array[Int], B: Array[Int]): Array[Int] = {
    println(B.indices.sortBy(B).toList)

    A.foldLeft(new Array[Int](A.length))((acc: Array[Int], el: Int) => {
      println(s"value $el position ${getNewPosition(el, B)} length ${A.length}")
      acc(getNewPosition(el, B)) = el
      acc
    })

  }

  def main(args: Array[String]): Unit = {
    println(advantageCount(Array(12, 24, 8, 32), Array(13, 25, 32, 11)).toList)
  }
}
