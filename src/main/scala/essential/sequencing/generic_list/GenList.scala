package essential.sequencing.generic_list

case object GenEnd extends GenList
final case class GenPair(h: Int, t: GenList) extends GenList

sealed trait GenList {

  def fold[A](end: A, f: (Int, A) => A): A =
    this match {
      case GenEnd          => end
      case GenPair(hd, tl) => f(hd, tl.fold(end, f))
    }

//  def double: GenList =
//    this match {
//      case GenEnd => GenEnd
//      case GenPair(hd, tl) => GenPair(hd * 2, tl.double)
//    }

  def length: Int = fold[Int](0, (_, t) => t + 1)
  def sum: Int = fold[Int](0, (h, t) => h + t)
  def product: Int = fold[Int](1, (h, t) => h * t)
  def double: GenList = fold[GenList](GenEnd, (h, t) =>  GenPair(h*2, t))
}

object Solution2 {
  def main(args: Array[String]): Unit = {
    val example = GenPair(1, GenPair(2, GenPair(3, GenEnd)))

    assert(example.length == 3)
    assert(example.t.length == 2)
    assert(GenEnd.length == 0)

    assert(example.sum == 6)
    assert(GenEnd.sum == 0)

    assert(example.product == 6)
    assert(GenEnd.product == 1)

    assert(example.double == GenPair(2, GenPair(4, GenPair(6, GenEnd))))
  }
}