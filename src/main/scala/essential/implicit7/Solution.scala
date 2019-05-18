package essential.implicit7


object Solution extends App {
  case class Person(name: String, email: String)

  trait Equal[A] {
    def equal(v1: A, v2: A): Boolean
  }

  object EmailEqual extends Equal[Person] {
    override def equal(v1: Person, v2: Person): Boolean = v1.email == v2.email
  }

  implicit object EmailNameEqual extends Equal[Person] {
    override def equal(v1: Person, v2: Person): Boolean = v1.email == v2.email && v1.name == v2.name
  }

  object Eq {
    def apply[A] (p1 : A, p2 : A)(implicit eq: Equal[A]): Boolean = eq.equal(p1, p2)
  }

  Eq(Person("Vadim", "vadim@gmail.com"), Person("Alina", "alina@gmail.com"))
  println("Test")
}

