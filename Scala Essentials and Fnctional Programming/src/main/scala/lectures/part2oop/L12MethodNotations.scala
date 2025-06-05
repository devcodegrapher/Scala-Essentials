package lectures.part2oop

object L12MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {

    def likes(movie: String): Boolean = movie == favoriteMovie

    // In Scala we have freedom to choose methods name as operators name
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent // this can only be done when method accepts only one argument

  // Infix notation = operator notation (syntactic sugar => more resemble with natural language)

  // "Operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))
  println(1 + 2) // same as 1.+(2)

  // ALL OPERATORS ARE METHODS
  // Akka actors have ! ?

  // Prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  println(!mary) // same as mary.unary_! or mary.unary_!()
  // unary_ prefix only works with - + ~ !

  // Postfix notation -> only available to method without parameter
  println(mary.isAlive)
  // println(mary isAlive)

  // Special method => apply
  println(mary.apply())
  println(mary()) // equivalent
}