package essential.classes.type_or_value
import essential.classes.Cat
import org.scalatest.{FunSuite, Matchers, PropSpec}
import org.scalatest.prop.PropertyChecks

class ChipShopTest extends PropSpec with Matchers with PropertyChecks {

  property("empty counter contains 0 not empty contains value") {
    forAll { food: String =>
      val cat = Cat("White", food)
      food match {
        case "Chipse" => ChipShop.willServe(cat) shouldBe true
        case _        => ChipShop.willServe(cat) shouldBe false
      }

    }
  }

}
