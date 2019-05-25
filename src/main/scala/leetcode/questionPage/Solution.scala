package leetcode.questionPage

object Solution {
  def isMatch(s: String, p: String): Boolean = s.length match {
    case 0                                   => true
    case 1 if p == "?" || p == "*" || s == p => true
    case 1                                   => false
    case _ if s.length == p.length =>
      s.head match {
        case _ if p.head == s.head              => isMatch(s.tail, p.tail)
        case _ if p.head == '?' | p.head == '*' => isMatch(s.tail, p.tail)
        case _                                  => false
      }
    case _ if s.length > p.length && p.contains('*') =>
      p.head match {
        case '*' => isMatch(s.substring(s.length - p.tail.length), p.tail)
        case _   if s.head == p.head | s.head == '?' => isMatch(s, p.tail)
        case _   => false
      }
    case _ => false
  }

  def main(args: Array[String]): Unit = {
    println(isMatch("a", "a"))
    println(isMatch("a", "aa"))
    println(isMatch("a", "*"))
    println(isMatch("", "a"))
    println(isMatch("cb", "?a"))
    println(isMatch("cb", "?b"))
    println(isMatch("aa", "*"))
    println(isMatch("adceb", "*a*b"))
  }
}