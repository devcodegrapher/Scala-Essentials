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

  calledByValue(1257387745764245L) // call by value first calculate the expression of the value of the expression and then it uses it in every call
  calledByName(System.nanoTime()) // call by name passes expression  every time when method is called , that's why you will find every time new value

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //  printFirst(infinite(), 34) // stack overflow
  printFirst(34, infinite()) // this will not throw error because call by name supports lazy loading ,
  // as you can see 'y' is not getting used any where in expression so it will not execute the infinite method

}