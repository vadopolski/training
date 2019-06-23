package leetcode.my_hash_set
import scala.collection.mutable

class MyHashSet() {

  /** Initialize your data structure here. */
  var initialSize = 16
  var loadFactor = 0.75
  var size = 0
  var data = new Array[mutable.ListBuffer[Int]](initialSize)

  def add(key: Int): Unit = {
    if(size == loadFactor * initialSize) {
      initialSize = initialSize * 2
      val dataNew = new Array[mutable.ListBuffer[Int]](initialSize)
      data.filter(_ != null ).foreach(list => {
        list.foreach(x => insert(dataNew, x))
      })
      data = dataNew
    }
    insert(data, key)
    size += 1
  }

  private def insert(data: Array[mutable.ListBuffer[Int]], key: Int): Unit = {
    val idx = key.hashCode % initialSize
    if(data(idx) == null) {
      val list = new mutable.ListBuffer[Int]()
      list += key
      data(idx) = list
    }
    else {
      val list = data(idx)
      if(!list.contains(key)) list += key
    }
  }

  def remove(key: Int): Unit = {
    val idx = key.hashCode % initialSize
    if(data(idx) != null) {
      val list = data(idx)
      val idxToRemove = list.indexOf(key)
      if(idxToRemove != -1) {
        list.remove(idxToRemove)
        size -= 1
      }
    }
  }

  /** Returns true if this set contains the specified element */
  def contains(key: Int): Boolean = {
    val idx = key.hashCode % initialSize
    if(data(idx) != null) {
      val list = data(idx)
      return list.contains(key)
    }
    false
  }
}

object MyHashSet{
  def main(args: Array[String]): Unit = {
    var obj = new MyHashSet()
    obj.add(105)
    obj.add(9)
    obj.add(995)
    obj.add(235)
    obj.add(11)
    obj.add(12312312)
    obj.add(13323)
    obj.add(11)
    obj.remove(5)
    var param_3 = obj.contains(5)

  }
}