package tinkoff.test

class StaticTest {
  def f = 5
}

object StaticTest {
  def apply(): StaticTest = new StaticTest()
  def f =6

  def main(args: Array[String]): Unit = {
    println(StaticTest().f)
  }
}