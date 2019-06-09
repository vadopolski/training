package essential.traits

sealed trait Color {
  def red: Int
  def green: Int
  def blue: Int
  def isLight: Boolean = (red + green + blue) / 255 * 3 > 255 / 2
  def isDark: Boolean = !isLight
}

object Red extends Color {
  val red: Int = 255
  val green: Int = 0
  val blue: Int = 0
}

object Pink extends Color {
  val red: Int = 255
  val green: Int = 20
  val blue: Int = 47
}

object Yellow extends Color {
  val red: Int = 255
  val green: Int = 211
  val blue: Int = 0
}

final case class CustomColor(red: Int, green: Int, blue: Int) extends Color
