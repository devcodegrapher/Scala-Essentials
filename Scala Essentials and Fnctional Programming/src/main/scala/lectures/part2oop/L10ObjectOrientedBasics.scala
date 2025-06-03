package lectures.part2oop

object L10ObjectOrientedBasics extends App {
  val person = new Person("Jhon",26)
  println(person.age)
  // println(person.name) -> this will throw error , as name is class parameter not a field/member
  person.greet("vivek")
  person.greet()
}

class Person(name:String, val age:Int = 0) {
  // body
  val x = 2
  println(1+3)
  //method
  def greet(name:String):Unit = println(s"${this.name} says:Hi, $name")   // this keyword is used for differentiating between member and local fields
  //overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  def this (name:String) = this(name,0)
  def this() = this("John Doe")
}

// class parameter are not FIELDS meaning these are not class members