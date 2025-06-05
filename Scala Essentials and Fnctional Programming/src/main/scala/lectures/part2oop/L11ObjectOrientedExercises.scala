package lectures.part2oop

object L11ObjectOrientedExercises extends App {

  val author = new Writer("Abhishek", "Kumar", 1812)
  val imposter = new Writer("Charles", "Singh", 1812)
  val novel = new Novel("Learn Scala", 1861, author)

  println(novel.authorAge)
  // println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))
}

/**
 * Novel and a Writer
 * Writer: first name, surname, year
 * - method full name - returns full name + surname
 *
 * Novel: name, year of release, author
 * - authorAge
 * - isWrittenBy(author)
 * - copy (new year of release) = new instance of novel
 */

class Writer(firstName: String, surName: String, val year: Int) {
  def fullName: String = firstName + " " + surName
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

/**
 * Counter class
 * - receives an int value
 * - method current count
 * - method to increment/decrement (inc and dec by one => new Counter)
 * - overload inc/dec to receive an amount
 */
class Counter(val count: Int) {

  def inc = {
    println("incrementing")
    new Counter(count + 1) // immutability
  }

  def dec = {
    println("decrement")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
    // else new Counter(count + n)
  }

  def dec(n: Int): Counter =
    if (n <= 0) this
    else dec.dec(n - 1)
}

class counter(value: Int, count: Int) {
  def currentCount(): Int = value
  def incrementCounter(inc: Int): Int = value + inc
  def decrementCounter(dec: Int): Int = value - dec
  def incrementCounter(): counter = new counter(1, 1)
  def decrementCounter(): counter = new counter(1, 1)
}