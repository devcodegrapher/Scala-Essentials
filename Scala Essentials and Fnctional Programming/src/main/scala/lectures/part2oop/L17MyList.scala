package lectures.part2oop

abstract class MyList {
  /*
  head = first element of the list
  tail = remainder of the list
  isEmpty = is this empty
  add(int) => new list with this element added
  toString => a string representation of the list
   */

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException

  override def tail: MyList = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add(element: Int): MyList = new Cons(element, this)

  override def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)
  def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)
  println(list.toString)
}

/*
TAKEAWAYS
Scala offers class based inheritance
. access modifiers : private , protected , default(none = public)
.need to pass in constructor arguments to parent class

Derived classes can override members or methods
Reuse parent fields/methods with super
prevent inheritance with final and sealed
abstract classes
traits
inheriting from a class and multiple traits
 */