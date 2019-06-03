package essential.classes

final case class Counter(i: Int = 0) {
  def inc: Counter = inc()
  def dec: Counter = dec()
  def inc(amount: Int = 1): Counter = Counter(i + 1)
  def dec(amount: Int = 1): Counter = Counter(i - 1)
  def count: Int = i
  def addjust(adder: Adder): Counter = Counter(adder.add(count))
}

case class Adder(amount: Int) {
  def add(in: Int):Int = in + amount
}

object SolutionCounter {
  def main(args: Array[String]): Unit = {
    println(Counter(10).inc.dec(3).inc(3).inc.count)
    println(Counter().inc.dec.inc.inc.count)

    val add = Adder(3)
    val counter = Counter(5)
    val counter2 = counter.copy()
    println(s"Result adjust = ${counter.addjust(add).count}")


  }
}
