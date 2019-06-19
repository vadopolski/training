package essential.sequencing.generic_list

case object GenEnd extends GenList
final case class GenIntPair(h: Int, t: GenList) extends GenList

sealed trait GenList {

  def fold(end: Int, f: (Int, Int) => Int ): Int =
    this match {
      case GenEnd => end
      case GenIntPair(hd, tl) => f(hd, tl.fold(end, f))
    }

  def double: GenList =
    this match {
      case GenEnd => GenEnd
      case GenIntPair(hd, tl) => GenIntPair(hd * 2, tl.double)
    }

  def length: Int = fold(0, (_, x) => x + 1)
  def sum: Int = fold(0, (h, t) => h + t)
  def product: Int = fold(1, (h, t) => h*t)


}

object Solution2 {
  def main(args: Array[String]): Unit = {
    val example = GenIntPair(1, GenIntPair(2, GenIntPair(3, GenEnd)))

    assert(example.length == 3)
    assert(example.t.length == 2)
    assert(GenEnd.length == 0)

    assert(example.sum == 6)
    assert(GenEnd.sum == 0)

    assert(example.product == 6)
    assert(GenEnd.product == 1)

    assert(example.double == GenIntPair(2, GenIntPair(4, GenIntPair(6, GenEnd))))
  }
}