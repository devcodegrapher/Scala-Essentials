package lectures.part2oop

object L20CaseClasses extends App {

  // scala specific feature
  /*
  equals ,hashCode, toString
   */

  case class Person(name: String, age: Int)
  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  // println(jim.name) // this statement is valid bcz Person is a case class

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim.toString) // -> o/p -> Person(Jim,34)

  // 3. equals and hashcode implemented OOTB
  val jim2 = new Person("Jim", 34)
  //  val jim3 = jim2
  println(jim == jim2) // -> o/p - true   // doubt (why is this true as both are pointing to different references)

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)
  println(jim == jim3) // o/p-> false

  // 5. CCs have companion objects
  //  compiler automatically makes companion object for the case class
  val thePerson = Person
  val mary = Person("Mary", 23) // also provide builtin apply method for instantiation

  // 6. CCs are serializable - can send instances of case classes through the network and in between JVM
  // used specifically dealing with AKKA framework
  // Akka deals with sending serializable messages through the network and our messages are in general practice are case classes

  // 7. CCs have extractor patterns = CCs can be used in Pattern matching (powerful scala feature)

  // 8. case objects
  // case objects have same nproperty as case classes, except they don't get companion objects because they are there own companion objects.
  case object UnitedKingDom {
    def name: String = "The UK of GB and NI"
  }

  /*
  Expand Mylist - use case classes and case objects
   */

  /*
  Takeaways
  Quick lightweight data structures with little boilerplate
  case class person(name: String, age:int)

  companions already implemented -> val bob + Person("Bob",26)
  sensible equals, hashcode , toString
  Auto promoted params to fields -> bob.name

   */
}