package essential.classes.type_or_value
import essential.classes.Cat

object ChipShop {
  def willServe(cat: Cat): Boolean ={
    cat match {
      case Cat(_, "Chips") => true
      case _ => false
    }
  }
}