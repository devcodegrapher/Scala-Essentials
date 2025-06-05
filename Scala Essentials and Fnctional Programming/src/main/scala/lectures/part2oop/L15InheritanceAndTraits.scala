package lectures.part2oop

object L15InheritanceAndTraits extends App {

  // Scala has single class inheritance much like other languages
  // Extending a class means inheriting all the non-private fields and methods

  class Animal {
    val creatureType = "wild"
    def eat = println("chicken")
  }

  class Cat extends Animal

  val cat = new Cat
  // cat.eat // valid expression it will print chicken

  /**
   * cat subclass of Animal
   * Animal superclass of cat
   */

  // Private methods/fields are only accessible within the class
  // Protected methods/fields are only accessible within class and its sub class
  // but not accessible outside the subclass

  /**
   * class Animal {
   *   protected def eat = println("chicken")
   * }
   * class Cat extends Animal {
   *   def crunch = {
   *     eat
   *     println("crunch crunch")
   *   }
   * }
   */

  // Access modifier in scala is private, protected and no modifier, which by default means public.

  // Constructors
  // JVM calls constructor of parent class before calling constructor of derived class, this is rule of JVM
  // Scala compiler forces you to guarantee that there is a correct super constructor to call
  // when using such a derived class

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idcard: String) extends Person(name, age)
  // class Adult(name: String, age: Int, idCard: String) extends Person(name) -> correct

  // Overriding
  class Dog(override val creatureType: String) extends Animal {
    // override val creatureType = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }

  // val dog = new Dog
  val dog = new Dog("K-9")
  dog.eat // => "crunch crunch"
  println(dog.creatureType) // => o/p domestic

  // Type substitution (broad: polymorphism)
  // All instance of derived class will use overridden method wherever possible
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat // o/p-> crunch crunch
  // method call will always go to most override version wherever possible. main feature of polymorphism

  // Overriding vs overloading
  // override -> supplying a different implementation in derived class
  // overloading -> multiple methods with different signatures but with the same name in the same class

  // super -> super is used when you want to refer a method or field from a parent class

  // Preventing overrides
  // 1. use keyword final on method -> if you make any field or method as final it cannot be override
  // final def eat = println("nom nom")

  // 2. use final on the entire class - if you write final keyword along with class definition
  // then this prevents the entire class from being extended.
  // numerical classes in scala are final, string type is also final

  // 3. seal the class => extend classes in this file, prevent extension in other files
  // sealed class Animal {
  //   ......
  // }
  // sealed keyword is often used when you want to be exhaustive in your type hierarchy
}