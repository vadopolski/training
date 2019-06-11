package essential.classes

import org.scalatest.{Matchers, PropSpec}
import org.scalatest.prop._


class CounterTest extends PropSpec with Matchers with PropertyChecks {

  property("empty counter contains 0 not empty contains value") {
    forAll { value: Int =>
      val empty = Counter()
      empty.count shouldBe 0
      val notEmpty = Counter(value)
      notEmpty.count shouldBe value
    }
  }

  property("empty counter with 2 inc and 2 dec contains 0 " +
    "not empty with 2 inc (inc) 2 dec (dec) contains value + 2 inc - 2 dec") {
    forAll { (value: Int, inc: Int, dec: Int) =>
      val empty = Counter().inc.dec.inc.dec
      empty.count shouldBe 0
      val notEmpty = Counter(value).inc(inc).dec(dec).inc(inc).dec(dec)
      notEmpty.count shouldBe value
    }
  }

}
