package leetcode.twosum

object Solution {
//  def get(nums: List[(Int, Int)], target: Int): (Int, Int) = nums match {
//    case head :: Nil => head
//    case head :: tail => get(tail, target)
//    case _ => None
//  }
//
//  def last(list: List[(Int, Int)]): Option[(Int, Int)] = list match {
//    case head :: Nil => Some(head)
//    case head :: tail => last(tail)
//    case _ => None
//  }
//
//  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
//    println(get(nums.zipWithIndex.toList, target))
//
//    Array(0,1)
//  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {

    def getIndices(map:Map[Int, Int], index: Int): Array[Int] = {
      val current = nums(index)

      map.get(target - current) match {
        case None => getIndices(map + (current -> index), index + 1)
        case Some(otherIndex) => Array(otherIndex, index)
      }
    }
    getIndices(Map(), 0)
  }

  def main(args: Array[String]): Unit = {
    println(twoSum(Array(2, 7, 11, 15), 9).toList)
  }
}