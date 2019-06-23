package leetcode.contest142

object Solution {
  def carPooling(trips: Array[Array[Int]], capacity: Int): Boolean = {
    go(trips.sortBy(_(1)), capacity)
  }

  def go(trips: Array[Array[Int]], capacity: Int): Boolean = {
    if (trips.head(0) > capacity) return false
    if (trips.length == 1) return true
    if (trips.head(2) > trips.tail.head(1) && trips.head(0) + trips.tail.head(0) > capacity) return false
    go(trips.tail, capacity)
  }


  def main(args: Array[String]): Unit = {
    println(carPooling(Array(Array(9,3,6),Array(8,1,7),Array(6,6,8), Array(8,4,9), Array(4,2,9)), 28))
  }
}