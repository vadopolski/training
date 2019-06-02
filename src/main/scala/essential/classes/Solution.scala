package essential.classes

class Cat(val colour: String, val food: String)

object ChipShop {
  def willServe (cat: Cat): Boolean = {
    cat.food == "Chips"
  }
}

object Solution {

  def main(args: Array[String]): Unit = {
    println("test")
    val oswald = new Cat("Black", "Milk")
    val henderson = new Cat( "Ginger", "Chips")
    val quen = new Cat( "Tabby and white", "Curry")
    println(ChipShop.willServe(henderson))
    println(ChipShop.willServe(oswald))

  }
}