package subbotin.interval_count

object Solution {
  def getIntervalAmount(ints: List[Double]): Int =
    if (ints.nonEmpty)
      ints
        .foldLeft(ints.head, 1) {
          case (acc, el) if (acc._1 - el) < -1 => (el, acc._2 + 1)
          case (acc, _)                        => acc
        }
        ._2
    else 0

  def main(args: Array[String]): Unit = {
    println(getIntervalAmount(List(-5, -3, 0, 1, 5)))
    println(getIntervalAmount(List(-5, -3, 0.5, 0, 0.5, 1, 5)))
    println(getIntervalAmount(List()))
  }
}
