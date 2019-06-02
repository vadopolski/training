package leetcode.intersections

case class Interval(start: Int, end: Int)

object Interval {
  def apply(start: Int, end: Int) = new Interval(start, end)
}

object Solution {
  def intervalIntersection(a: Array[Interval], b: Array[Interval]): Array[Interval] = {
    def intervalIntersection(i: Int, j: Int, intersection: Array[Interval]): Array[Interval] = {
      import math.{max, min}

      if (i >= a.length || j >= b.length) {
        intersection
      } else if (a(i).end < b(j).start) {
        intervalIntersection(i + 1, j, intersection)
      } else if (b(j).end < a(i).start) {
        intervalIntersection(i, j + 1, intersection)
      } else if (a(i).end < b(j).end) {
        intervalIntersection(i + 1, j, intersection :+ Interval(max(a(i).start, b(j).start), min(a(i).end, b(j).end)))
      } else if (a(i).end > b(j).end) {
        intervalIntersection(i, j + 1, intersection :+ Interval(max(a(i).start, b(j).start), min(a(i).end, b(j).end)))
      } else {
        intervalIntersection(
          i + 1, j + 1, intersection :+ Interval(max(a(i).start, b(j).start), min(a(i).end, b(j).end)))
      }
    }

    intervalIntersection(0, 0, Array())
  }


  def main(args: Array[String]): Unit = {
    println(
      intervalIntersection(
        Array(Interval(0, 2), Interval(5, 10), Interval(13, 23), Interval(24, 25)),
        Array(Interval(1, 5), Interval(8, 12), Interval(15, 24), Interval(25, 26))
      ).toList
    )

  }
}