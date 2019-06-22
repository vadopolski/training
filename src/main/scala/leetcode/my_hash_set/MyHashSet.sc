class MyHashSet() {
  var map: Map[Int, Int] = Map.empty

  /** Initialize your data structure here. */
  def add(key: Int): Unit = {
    map = map + (key -> 1)
  }

  def remove(key: Int): Unit = {
    map = map - key
  }

  /** Returns true if this set contains the specified element */
  def contains(key: Int): Boolean = map.contains(key)
}

var obj = new MyHashSet()
obj.add(5)
obj.remove(5)
var param_3 = obj.contains(5)

