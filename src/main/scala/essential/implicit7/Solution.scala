package essential.implicit7

case class Person(name: String, email: String)

trait Equal[A] {
  def equal(v1: A, v2: A): Boolean
}

object Equal {
  def apply[A](implicit instanse: Equal[A]): Equal[A] = instanse
}

object EmailImplicit {
  implicit object EmailEqual extends Equal[Person] {
    override def equal(v1: Person, v2: Person): Boolean = v1.email == v2.email
  }
}

object EmailNameEqualImplicit {
  implicit object EmailNameEqual extends Equal[Person] {
    override def equal(v1: Person, v2: Person): Boolean =
      v1.email == v2.email && v1.name == v2.name
  }
}

object Eq {
  def apply[A](p1: A, p2: A)(implicit eq: Equal[A]): Boolean = eq.equal(p1, p2)
}

object Solution extends App {

  println("Test")

  def emailNameWithObject(): Unit = {
    import EmailNameEqualImplicit._
    println(
      Equal[Person].equal(
        Person("Noel", "noel@example.com"),
        Person("Alina", "alina@gmail.com")
      )
    )

  }

  def emailNameEqual(): Unit = {
    import EmailNameEqualImplicit._
    println(
      Eq(Person("Vadim", "vadim@gmail.com"), Person("Alina", "alina@gmail.com"))
    )
  }

  def emailEqual(): Unit = {
    import EmailImplicit._
    println(
      Eq(Person("Vadim", "alina@gmail.com"), Person("Alina", "alina@gmail.com"))
    )
  }

  emailNameEqual()
  emailEqual()
  emailNameWithObject()
}
