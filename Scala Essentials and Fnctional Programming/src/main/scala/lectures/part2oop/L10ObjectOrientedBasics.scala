package lectures.part2oop

/**
 * Class organizes data and the behavior that is code and instantiation
 * means concrete implementation of the code
 */
object L10ObjectOrientedBasics extends App {

  val person = new Person("John", 26) // instantiation of a class
  println(person.age)

  // Class parameters are not fields
  // println(person.name) -> this will throw error, as name is class parameter not a class field/member
  person.greet("vivek")
  person.greet()
}

// Class is defined outside object because class definitions can sit on the top level code
class Person(name: String, val age: Int = 0) { // class declaration and constructor of the class

  // Body
  val x = 2 // fields
  println(1 + 3) // for every instantiation of the class the whole code block will be evaluated.

  // Method
  def greet(name: String): Unit =
    println(s"${this.name} says: Hi, $name") // this keyword is used for differentiating between member and local fields

  // Overloading - defining method with same name and different signature
  def greet(): Unit = println(s"Hi, I am $name")

  // def greet(): Int = 42 // this will throw error // 2 methods with same signature but different return type

  // Multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

// Class parameters are not FIELDS meaning these are not class members
// Convert a class parameter to a field would be to add the val or var keyword