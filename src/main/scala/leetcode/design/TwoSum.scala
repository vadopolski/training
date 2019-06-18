package leetcode.design

class TwoSum() {
  var sum = scala.collection.mutable.Set[Int]()
  var numbers = scala.collection.mutable.Set[Int]()

  def add(number: Int): Unit =  {
      numbers.foreach(el => sum.add(number + el))
      numbers += number
    }

  def find(value: Int): Boolean = sum.contains(value)
}

object TwoSum {
  def main(args: Array[String]): Unit = {
    var obj = new TwoSum()
    obj.add(1)
    obj.add(3)
    obj.add(5)
    println(obj.find(4))
    println(obj.find(7))
  }
}
