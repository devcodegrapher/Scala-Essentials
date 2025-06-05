package lectures.part1basics

object L7CallByValuevsCallByName extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  // Call by value first calculates the expression value and then uses it in every call
  calledByValue(1257387745764245L)

  // Call by name passes expression every time when method is called,
  // that's why you will find a new value every time
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  // printFirst(infinite(), 34) // stack overflow

  // This will not throw error because call by name supports lazy loading,
  // as you can see 'y' is not getting used anywhere in expression
  // so it will not execute the infinite method
  printFirst(34, infinite())
}