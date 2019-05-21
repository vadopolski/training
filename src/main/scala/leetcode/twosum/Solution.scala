package leetcode.twosum

object Solution {



  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val ind = nums
      .filter(el => nums.indexOf(el) != 0 && nums(0) + el == target)

    println(ind)

    Array(0,1)
  }


  def main(args: Array[String]): Unit = {
    println(twoSum(Array(2, 7, 11, 15), 9).toList)
  }
}