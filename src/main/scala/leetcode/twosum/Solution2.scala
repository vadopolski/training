package leetcode.twosum

object Solution2 {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {

    def get(map: Map[Int, Int], i: Int): Array[Int] = {
      map.get(target - nums(i)) match {
        case None    => get(map + (nums(i) -> i), i + 1)
        case Some(j) => Array(j, i)
      }
    }

    get(Map[Int, Int](), 0)
  }

  def main(args: Array[String]): Unit = {
    println(twoSum(Array(2, 7, 11, 15), 9).toList)
  }
}
