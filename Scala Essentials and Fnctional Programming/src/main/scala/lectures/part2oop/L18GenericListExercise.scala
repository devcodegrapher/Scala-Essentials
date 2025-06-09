package lectures.part2oop

/*
head = first element of the list
tail = remainder of the list
isEmpty = is this list empty
add(int) => new list with this element added
toString => a String representation of the list
 */

abstract class GenericList[+A] {
  def head: A
  def tail: GenericList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): GenericList[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
}

object EmptyList extends GenericList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: GenericList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): GenericList[B] = new ListCons(element, EmptyList)
  def printElements: String = ""
}

class ListCons[+A](h: A, t: GenericList[A]) extends GenericList[A] {
  def head: A = h
  def tail: GenericList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): GenericList[B] = new ListCons(element, this)
  def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object L18GenericListExercise extends App {
  // expand MyList to be generic

  val listOfIntegers: GenericList[Int] = new ListCons(1, new ListCons(2, new ListCons(3, EmptyList)))
  val listOfStrings: GenericList[String] = new ListCons("Hello", new ListCons("Scala", EmptyList))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}

/**
 * Takeaways
 * use the same code on many (potentailly unrelated) types:
 * trait List[T] {
 * def add(elem: T)
 * }
 *
 * Generic methods
 * object List {
 * def single[A] (element: A) : List[A] = ???
 * }
 *
 * Multiple type parameters
 * trait Map[Key,Value] {
 * ...............
 * }
 *
 * Variance : IF B extends A , should list[B] extend List[A]
 * trait List[+A] -> yes (covariant)
 * trait List[A] -> no(invariant) - default
 * trait List[-A] -> hell no! (contravariant)
 *
 * Bounded Types
 * class car
 * class supercar extends car
 * class garage[T <: car] (car:T)
 *
 *
 */