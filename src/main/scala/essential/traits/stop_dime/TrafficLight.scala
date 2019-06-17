package essential.traits.stop_dime

sealed trait TrafficLight {

  def next: TrafficLight = this match {
    case Red    => Green
    case Green  => Yellow
    case Yellow => Red
  }
}

case object Red extends TrafficLight
case object Green extends TrafficLight
case object Yellow extends TrafficLight

object Example extends App {
  println(Red.next.next.next.next.next)

}