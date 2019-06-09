package essential.traits

sealed trait DivisionResult

final case class Finite(result: Int) extends DivisionResult
case object Infinite extends DivisionResult

object Divide {
  def apply(a: Int, b: Int): DivisionResult = b match {
    case 0 => Infinite
    case _ => Finite(a / b)
  }
}

object Test extends App {
  val x = Divide(5, 2)
  println(x)

  val y = Divide(1, 0)
  println(y)
}