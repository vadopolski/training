package tinkoff.plusamount

object Solution {
  def getPlusAmount(input: List[Int]): (Int, Int) = {
    input.foldLeft((0,0)){
      case (acc, el) if el >= 0 => (acc._1, acc._2 +1)
      case (acc, _) => (acc._1 + 1, acc._2)
    }
  }

}