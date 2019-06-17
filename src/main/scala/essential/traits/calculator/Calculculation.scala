package essential.traits.calculator

sealed trait Calculation

final case class Success(result: Int) extends Calculation
final case class Failure(message: String) extends Calculation

object Calculator {
  def +(calculation: Calculation, element: Int): Calculation =
    calculation match {
      case Success(result)  => Success(result + element)
      case Failure(message) => Failure(message)
    }

  def -(calculation: Calculation, element: Int): Calculation =
    calculation match {
      case Success(result)  => Success(result - element)
      case Failure(message) => Failure(message)
    }

  def /(calculation: Calculation, element: Int): Calculation =
    calculation match {
      case Failure(message) => Failure(message)
      case Success(_) if element == 0 => Failure("Division by zero")
      case Success(result)  => Success(result - element)
    }

}

object Calculation {
  def main(args: Array[String]): Unit = {
    assert(Calculator.+(Success(1), 1) == Success(2))
    assert(Calculator.-(Success(1), 1) == Success(0))
    assert(Calculator.+(Failure("Badness"), 1) == Failure("Badness"))

    assert(Calculator./(Success(4), 2) == Success(2))
    assert(Calculator./(Success(4), 0) == Failure("Division by zero"))
    assert(Calculator./(Failure("Badness"), 0) == Failure("Badness"))
  }
}