package stepic

object Solution {

  implicit class IntHelper(i: Int) {
    def pow(p: Int): Double = Math.pow(i, p)
  }

  def normalDistribution(mu: Double, sigma: Double, x: Double): Double = {
    1 / (sigma * Math.sqrt(2 * Math.PI)) * Math.pow(
      Math.E,
      -1 * Math.pow(x - mu, 2) / (2 * Math.pow(sigma, 2))
    )
  }

  def main(args: Array[String]): Unit = {
    println(normalDistribution(1, 1, 1))
    println(2 pow 2)
  }

}
