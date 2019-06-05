package essential.classes.compaign

class Person (firstName: String, lastName: String){
  def name = s"Firstname $firstName"
  def surName = s"Lastname $lastName"
}

object Person {

  def apply(name: String): Person = {
    val nameArr = name.split(" ")

    new Person(nameArr(0), nameArr(1))
  }

  def main(args: Array[String]): Unit = {
    val pers = Person("Vadim Opolski")
    println(pers.name)
  }

}
