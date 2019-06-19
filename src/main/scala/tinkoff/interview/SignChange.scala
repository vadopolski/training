package tinkoff.interview

object SignChange {

  def getSignChange(input: List[Int]): Int = input.foldLeft((0, input.head)){
    case (acc, el) if el >= 0 && acc._2 < 0 || el < 0 && acc._2 >= 0 => (acc._1 + 1, el)
    case (acc, el) => (acc._1, el)
  }._1

  def main(args: Array[String]): Unit = {

    val test = List(1, -5, 6, -8, 10, -15, -15)


    println(getSignChange(test))

  }
}