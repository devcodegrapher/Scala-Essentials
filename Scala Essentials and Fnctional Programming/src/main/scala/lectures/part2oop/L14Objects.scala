package lectures.part2oop

object L14Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("STATIC")
  // THE WORKAROUND FOR IT IS OBJECT (CLASS LEVEL FUNCTIONALITY)
  // TO USE CLASS LEVEL DEFINITION IN SCALA WE USE OBJECTS.
  // OBJECTS CAN HAVE VAL AND VARS AND CAN ALSO HAVE METHOD DEFINITION
  // OBJECTS CAN BE DEFINED IN A SIMILAR WAY THAT CLASSES CAN WITH THE EXCEPTION
  // THAT OBJECTS DO NOT RECEIVE PARAMETERS

  object Person { // DEFINED TYPE + IT'S ONLY INSTANCE
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // Factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
    // name of this method can be anything just kept it apply because of certain reason
  }

  class Person(val name: String) {
    // instance-level functionality
  }

  // Companions -> pattern of writing classes and objects with the same name
  // in the same scope is called companions

  // What did we achieve from this pattern?
  // The whole code that will ever write will reside in either a class and we can access it from an instance
  // or it will reside inside of a singleton object and we can access that by accessing the singleton object
  // which means that all the code that will ever going to be access will be accessed from some kind of instance,
  // either a regular instance or the singleton instance
  // that means scala is actually a truly OO language, scala is more object oriented language,
  // including java, which is kind of funny because scala was designed as a functional language
  // and it's actually very successful

  println(Person.N_EYES)
  println(Person.canFly)

  // SCALA OBJECT => SINGLETON INSTANCE
  val mary = Person
  val john = Person
  println(mary == john) // op=> True because Mary and John point to the same instance, which is object called person.

  val ram = new Person("Ram")
  val shyam = new Person("Shyam")
  println(ram == shyam) // false

  // Often we have factory methods in the Singleton objects that can provide instance of person class
  val bobbie = Person(ram, shyam) // Person.apply(ram, shyam)
  // person singleton object is callable like a function, which is pretty cool
  // so it actually looks like a constructor with small difference that this is actually
  // the apply method in person singleton object

  // Scala Applications = scala object with def main(args: Array[String]): Unit
  // this is because scala code is compiled to byte code that will be executed on jvm
  // and to execute on jvm entry point have to be public static
  // or object can extend APP which already have main method

  /**
   * Takeaways:
   * - Scala doesn't have "static" values/methods -> scala have alternative for this as scala objects
   * - Scala Objects is its own type and is only instance of that type
   * - can achieve Singleton pattern in one line!
   * - Scala Companions
   * - can access each other's private members
   * - scala is more OO than java
   * - Scala applications
   * - def main(args: Array[String]): Unit
   * - object MyApp extends App
   */
}