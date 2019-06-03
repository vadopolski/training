package leetcode.questionPage

object Solution {
  def isMatch(s: String, p: String): Boolean = {
    def removeDublicate(input: String): String = input match {
      case "*" => "*"
      case "" => ""
      case _ if input.head == '*' && input.tail.head == '*' =>
        removeDublicate(input.tail)
      case _ => input.head + removeDublicate(input.tail)
    }

    def go(s: String, p: String): Boolean = (s, p) match {
      case (input, exp) if input.isEmpty || exp.isEmpty => false
      case (_, exp) if exp == "*"                       => true
      case (input, exp) if input == exp                 => true
      case (input, exp) if input.head == exp.head || exp.head == '?' =>
        go(input.tail, exp.tail)
      case (input, exp) if exp.head == '*' => go(input, exp.tail) || go(input.tail, exp)
      case _                               => false
    }

    go(s, removeDublicate(p))
  }


  def main(args: Array[String]): Unit = {

    println(isMatch("a", "a"))
    println(isMatch("a", "aa"))
    println(isMatch("a", "*"))
    println(isMatch("", "a"))
    println(isMatch("cb", "?a"))
    println(isMatch("cb", "?b"))
    println(isMatch("aa", "*"))
    println(
      isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
    "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"      )
    )
  }
}
