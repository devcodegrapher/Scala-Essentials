package lectures.part2oop

object L11ObjectOrientedExercises extends App {
  val author = new Writer("Abhishek","Kumar",1812)
  val imposter =  new Writer("Charles","Singh",1812)
  val novel = new Novel("Learn Scala", 1861 , author)

  println(novel.authorAge)
  //println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

}

/**
 * Novel and a Writer
 * Writer: first namr, surname, year
 * - method fullname
 *
 * Novel: name,year of release,author
 * - authorAge
 * - isWrittenBy(author)
 * - copy (new year of release)m= new instance of novel
 */

class Writer(firstName: String, surName: String, val year:Int) {
  def fullName:String = firstName + " "+surName
}

class Novel(name:String,year:Int,author: Writer) {
  def authorAge = year - author.year
  def isWrittenBy(author:Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear , author)
}

/**
 * Counter class
 * - receives an int value
 * - method current count
 * - method to increment /document  =>new Counter
 * - overload inc/dec to receive an amount

 *
 */
class counter(value:Int,count:Int) {
  def currentCount():Int = value
  def incrementCounter(inc:Int):Int = value + inc
  def decrementCounter(dec:Int):Int = value - dec
  def incrementCounter():counter = new counter(1,1)
  def decrementCounter():counter = new counter(1,1)
}