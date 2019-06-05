package tinkoff.plusamount

import org.scalatest.{Matchers, PropSpec}
import org.scalatest.prop._

import scala.util.Random

class SolutionTest extends PropSpec with Matchers with PropertyChecks {
  property("testGetPlusAmount") {
    val list10 = List(1,1,1,1,1,-1,-1,-1,-1,-1)
    Solution.getPlusAmount(list10) shouldBe (5,5)

    val random = new Random()
    val list   = List.fill(100000)(1)
    Solution.getPlusAmount(list) shouldBe (0, 100000)
  }
}