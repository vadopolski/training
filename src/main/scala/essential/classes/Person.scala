package essential.classes

case class Person(firstName: String, secondName: String) {
  def name: String = firstName
}

object Person {
  def apply(fullName: String): Person = {
    val names = fullName.split(" ")
    new Person(names(0), names(1))
  }

  def main(args: Array[String]): Unit = {
    println(Person("Vadim Opolski").name)
    println(Person("Ivan", "Lopatin").name)
  }
}
