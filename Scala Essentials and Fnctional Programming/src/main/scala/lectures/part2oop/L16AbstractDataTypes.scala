package lectures.part2oop

object L16AbstractDataTypes extends App {

  /**
   * Abstract Class - Class which contain unimplemented methods or abstract fields are called abstract classes.
   * and they are defined with keyword abstract
   * subclasses will provide value for abstract field and implementation of methods
   * Abstract classes can not be instantiated
   */
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  // class which is going to extend abstract class either should be abstract ot it should provide implementation of the unimplemented methods and fields

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behavior, abstract class = "thing"
}
