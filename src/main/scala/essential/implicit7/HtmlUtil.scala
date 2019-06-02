package essential.implicit7


trait HtmlWriter[A] {
  def write(in: A): String
}


object HtmlUtil extends App {
//  implicit object PersonWriter extends HtmlWriter[Person] {
//    override def write(in: Person): String = s"<span>${in.name} &lt;${in.email} &gt; </span>"
//  }
//
//
//  def htmlfy[A](data: A)(implicit writer : HtmlWriter[A]): String = {
//    writer.write(data)
//  }

//  println(HtmlUtil.htmlfy(Person("John", "jhn@mail.com")))




}
