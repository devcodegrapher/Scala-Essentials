package lectures.part2oop

object L19AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahhahahha")
  }

  /*
  equivalent with

  class AnonymousClasses$$anon$1 extends Animal {
  override def eat: Unit = println("ahahahahahha")
  }
  val funnyAnimal : Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help ?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(" this is override method definition call")
  }
  println(jim.sayHi)

  /**
   * TakeAways
   * Anonymous class works well for both abstract types and concrete classes
   * we can instatiate types and override fields or methods on the spot
   * trait Animal {
   * def eat : unit
   * }
   * val predetor = new Animal {
   * override def eat : unit = println("RAWR!")
   * }
   *
   * // rules
   * . pass in required constructor arguments if needed
   * . implement all abstract fields/methods
   *
   * Works for traits and classes (abstract or not)
   */
}