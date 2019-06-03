package subbotin

import scala.collection.mutable.ListBuffer

object Solution {

  def mergeSort(input: ListBuffer[Int]): ListBuffer[Int] = {

    def sort(a: Int, b: Int): Unit = b - a match {
      case 1 if input(a) > input(b) =>
        input(a) = input(a) + input(b)
        input(b) = input(a) - input(b)
        input(a) = input(a) - input(b)
      case _ =>
    }

    sort(0, input.length - 1)

    input
  }

  def main(args: Array[String]): Unit = {
    println(mergeSort(ListBuffer(4, 3)))
  }
}
