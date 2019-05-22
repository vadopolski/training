package leetcode.majorityel

object Solution {

  def majorityElement(nums: Array[Int]): Int = {
    if (nums.length == 1) return nums(0)

    def repeatedMap(acc: Map[Int, Int], i: Int): Map[Int, Int] = acc.get(nums(i)) match {
      case None if i != (nums.length - 1) => repeatedMap(acc + (nums(i) -> 1), i + 1)
      case Some(el) if i != (nums.length - 1) => repeatedMap(acc + (nums(i) ->(el + 1) ), i + 1)
      case _ => acc
    }

    println(repeatedMap(Map[Int, Int](), 0))
    repeatedMap(Map[Int, Int](), 0).maxBy(_._2)._1
  }

  def main(args: Array[String]): Unit = {
    println(majorityElement(Array(6,5,5)))
  }
}