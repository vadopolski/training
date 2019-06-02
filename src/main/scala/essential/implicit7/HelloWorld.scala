package essential.implicit7

object HelloWorld {

  def isTest(input: Array[Double]): Long = {
    val sorted = input.toList.sorted
    val diff = sorted(input.length-1) - sorted(0)
      println(diff)
    2L
  }



  def main(args: Array[String]):Unit = {
    println(isTest(Array(-2, 0.5, 1)))


  }
}