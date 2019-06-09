package essential.traits

sealed trait Feline {
  def colour: String
  def sound: String
}

case class Lion(colour: String,
                sound: String = "Roar",
                maneSize: Int) extends Feline

case class Pantera(colour: String,
                   sound: String = "Roar") extends Feline

case class Cat(colour: String,
               sound: String = "Roar",
               favouriteFood: String) extends Feline

