package leetcode.design.stack

class MinStack() {
  def push(x: Int):MinStack = this match {
    case _ => Element(x, this)
    case Empty() => Element(x, Empty())
  }

  def pop() {}
  def top(): Int = ???
  def getMin(): Int = this match {
    case Empty() => 0
    case Element(head, _) => this.help(head)
  }

  def help(min: Int): Int = this match {
    case Element(head, rest) if head < min => rest.help(head)
    case Element(head, rest) => rest.help(min)
    case Empty() => min
  }


}

final case class Empty() extends MinStack
final case class Element(value : Int, rest : MinStack) extends MinStack

object MinStack{
  def apply[V](): MinStack = Empty()
  
  def main(args: Array[String]): Unit = {
    val minStack : MinStack = MinStack().push(-5).push(0).push(-3)
    println(minStack.getMin())  // --> Returns -3
//    minStack.pop()
//    minStack.top()   //   --> Returns 0.
//    minStack.getMin() //  --> Returns -2.
  }
}

/**
  * Your MinStack object will be instantiated and called as such:
  * var obj = new MinStack()
  * obj.push(x)
  * obj.pop()
  * var param_3 = obj.top()
  * var param_4 = obj.getMin()
  */