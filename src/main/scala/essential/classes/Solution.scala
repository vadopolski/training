package essential.classes

final case class Cat(colour: String, food: String)

object ChipShop {
  def willServe (cat: Cat): Boolean = {
    cat.food == "Chips"
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    println("test")
    val oswald = Cat("Black", "Milk")
    val henderson = Cat("Ginger", "Chips")
    val quen = Cat("Tabby and white", "Curry")
    println(ChipShop.willServe(henderson))
    println(ChipShop.willServe(oswald))
  }
}