package essential.traits

sealed trait Feline {
  def colour: String
  def sound: String
}

final case class Lion(colour: String,
                      sound: String = "Roar",
                      maneSize: Int) extends Feline

final case class Pantera(colour: String,
                         sound: String = "Roar") extends Feline

final case class Cat(colour: String,
                     sound: String = "Roar",
                     favouriteFood: String) extends Feline
