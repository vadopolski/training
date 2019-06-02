package essential.classes

class Counter(val i: Int = 1) {
  def inc: Counter = inc()
  def dec: Counter = dec()
  def inc(amount: Int = 1): Counter = new Counter(i + 1)
  def dec(amount: Int = 1): Counter = new Counter(i - 1)
  def count: Int = i
  def addjust(adder: Adder): Counter = new Counter(adder.add(count))
}

class Adder(amount: Int) {
  def add(in: Int):Int = in + amount
}

object SolutionCounter {
  def main(args: Array[String]): Unit = {
    println(new Counter(10).inc.dec(3).inc(3).inc.count)
    println(new Counter().inc.dec.inc.inc.count)

    val add = new Adder(3)
    val counter = new Counter(5)
    println(s"Result adjust = ${counter.addjust(add).count}")


  }
}
