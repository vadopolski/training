package essential.traits.visitor
import java.util.Date

trait Visitor {
  def id: String
  // Unique id assigned to each user
  def createdAt: Date // Date this user first visited the site
  // How long has this visitor been around?
  def age: Long = new Date().getTime - createdAt.getTime
}
case class Anonymous(id: String,
                     createdAt: Date = new Date()) extends Visitor
case class User(id: String,
                email: String,
                createdAt: Date = new Date())
    extends Visitor

object EmailServiceObject {
  def apply(visitor: Visitor) : Unit = {
    visitor match {
      case User(_, email, _) => println(s"Sending email to + $email")
      case _ => println("Not possible to send email")
    }
  }

  def main(args: Array[String]): Unit = {
    EmailServiceObject(User("1","test", new Date()))
  }
}