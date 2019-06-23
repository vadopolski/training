package subbotin

object FindCommonSubstring {

  def findCommonSubstring(input: String, substring: String): String = input.length match {
    case 2 if input.contains(substring) => substring
    case 2 => ""
    case in if in < substring.length => findCommonSubstring(substring, input)
  }

  def main(args: Array[String]): Unit = {
    val str1 = "abcdefgh"
    val str2 = "abcd"

    println(findCommonSubstring("abb", "ab"))


  }


}
