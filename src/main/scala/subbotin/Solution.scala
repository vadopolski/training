package subbotin

object Solution {


  def mergeSort (input: List[Int]): List[Int] ={

    input match {
      case List(a, b) if a > b => List(b, a)
      case List(a, b) if a < b => List(a, b)
      case head :: tail => head :: mergeSort(tail)
    }
  }


  def main(args: Array[String]): Unit = {
    println(mergeSort(List(4,3,7)))
  }
}
