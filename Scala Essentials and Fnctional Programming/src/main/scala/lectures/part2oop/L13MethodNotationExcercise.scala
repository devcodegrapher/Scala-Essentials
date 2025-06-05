package lectures.part2oop

import scala.language.postfixOps

object L13MethodNotationExercise extends App {

  /**
   * 1. Overload the + operator
   * mary + " the rockstar" => new Person "Mary (the rockstar)"
   *
   * 2. Add an age to the person class
   * add a unary + operator => new person with the age + 1
   * +mary => mary with the age incremented
   *
   * 3. Add a "learns" method in the Person class => "mary learns scala"
   * Add a learnsScala method, calls learns method with "Scala".
   * Use it in postfix notation.
   *
   * 4. Overload the apply method
   * mary.apply(2) => "mary watched Inception 2 times"
   */

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {

    def +(nickname: String): Person = new Person(s"${this.name} ($nickname)", favoriteMovie)
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)
    // def unary_- (age: Int) = s"hello $age"

    def apply(): String = s"Hi My name is $name and my fav movie is $favoriteMovie and my age is $age"
    def learn(thing: String): String = s"$name is learning $thing"
    def learnScala = this learn "scala"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }

  val mary = new Person("mary", "inception")
  println((mary + "the Rockstar")()) // same as (mary + "the Rockstar").apply()
  println((+mary)())
  println(mary.learn("scala"))
  println(mary learnScala)
  println(mary(2))
  // println(mary.unary_-(2))
}

/**
 * Takeaways:
 * mary.likes("Inception")
 * mary likes "Inception" => infix notation => object method parameter
 * => for methods with one parameter
 *
 * ===== Prefix notation ===
 * mary.unary_! => equivalent = !mary
 * only allowed for: +, -, !, ~
 *
 * == Postfix notation ==
 * mary.isAlive ====== mary isAlive => only for method with no parameter
 *
 * apply() is special method
 * mary.apply("Hi there!")
 * mary("Hi there!")
 */