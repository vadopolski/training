package essential.traits

sealed trait Shape {
  def colour: Color
  def perimeter: Double
  def area: Double
}

trait Rectangular extends Shape {
  def sides: Int = 4
  def width: Double
  def height: Double
  def perimeter: Double = (width + height) * 2
  def area: Double = width * height
}

final case class Circle(radius: Double, color: Color) extends Shape {
  def perimeter: Double = 2 * Math.PI * radius
  def area: Double = Math.PI * radius * radius
  def colour: Color = color
}

final case class Rectangle(width: Double, height: Double, color: Color) extends Rectangular {
  def colour: Color = color
}

final case class Square(sideSize: Double, color: Color) extends Rectangular {
  def width: Double = sideSize
  def height: Double = sideSize
  def colour: Color = color
}


object Draw {
  def getColor(color: Color) = color match {
    case Yellow => "Yellow"
    case Red => "Red"
    case Pink => "Pink"
    case _ if color.isLight => "Light"
    case _ => "Dark"
  }


  def apply(shape: Shape): Unit = shape match {
    case Circle(rad, color) => println(s"A ${getColor(color)} circle of radius $rad")
    case Rectangle(wid, height, color) => println(s"A ${getColor(color)} rectangle of $wid and $height")
    case Square(side, color) => println(s"A ${getColor(color)} square with side $side")
  }

  def main(args: Array[String]): Unit = {
    Draw(Circle(10.0, Yellow))
    Draw(Rectangle(10.0, 5.0, CustomColor(255, 255, 255)))
    Draw(Square(10.0, Pink))
  }
}