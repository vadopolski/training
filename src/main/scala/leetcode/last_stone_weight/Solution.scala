package leetcode.last_stone_weight

object Solution {
  def lastStoneWeight(stones: Array[Int]): Int = {
    val list = stones.sorted(Ordering.Int.reverse)

    list.tail
      .foldLeft((list, list(0))) {
        case (acc, _) if acc._1.length == 1 || acc._1.length == 0 => acc
        case (acc, _) if acc._1.length == 2 =>
          (
            Array.emptyIntArray,
            if (acc._1(0) != acc._1(1)) Math.abs(acc._1(0) - acc._1(1))
            else 0
          )
        case (acc, el) if el == acc._2 =>
          (acc._1.tail.tail, acc._1.tail.tail.max)
        case (acc, el) =>
          (acc._1.tail.tail :+ Math.abs(el - acc._2), acc._1.tail.tail.max)
      }
      ._2
  }

  def main(args: Array[String]): Unit = {
    println(lastStoneWeight(Array(2, 7, 4, 1, 8, 1)))
  }
}
