package lectures.part1basics

import scala.annotation.tailrec

object L6Recusrion extends App {

  //jvm on top of which java runs uses a call stack to keep partial results so that it can get
  //back to computing the desired result , so each call of the recursive function uses stack frame

  // function to calculate factorial of a number
  def factorial(n:Int): Int = {
    if (n<=1) 1
    else {
      println("computing factorial of "+n+" - I first need factorial of "+ (n-1))
      val result = n * factorial(n-1)
      println("computed factorial of "+n)
      result
    }
  }
  //println(factorial(10))
// the problem with the above approach is jvm keeps all the calls on its internal stack , which has limited memory
  // println(factorial(5000)) // -> stack over flow error - bcz recursive depth is too big

  def anotherFactorial(n: BigInt): BigInt = {
    def factoryHelper(x: BigInt, accumulator: BigInt) : BigInt =
      if (x<=1) accumulator
      else factoryHelper(x-1,x*accumulator)
    factoryHelper(n,1)
  }

  println(anotherFactorial(5000))
  // factoryHelper(10,1)
  //factoryHelper(9,10*1)
  // factoryHelper(8,9*10*1)
  //......
  // factoryHelper(2,3*4.....*9*10*1)
  // factoryHelper(1,2*3*4*...*9*10*1)

  // it will work fine even without creating auxiliary function
  // this approach works fine because scala does not need to save intermediate result to be used later
  // it will not create extra stack frame for each call , replace the existing call
  // for a tail recursive approach recursive call should be last expression in the code block
  // @tailrec - this tells compiler that this function is supposed to be tail recursive , then compiler will issue an error " recursive call is not in tail position)

  // when you need loops ,use tail recursion


  /**
   * write tail recursive method for all below tasks
   * 1. concatenate a string
   * 2. is prime
   * 3. fibonacci series
   *
   */

  @tailrec
  def concatenateTailrec(aString: String , n: Int, accumulator: String) : String = {
    if (n <= 0) accumulator
    else concatenateTailrec(aString, n-1 , aString + accumulator)
  }

  // println(concatenateTailrec("hello",3,""))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimetailrec(t: Int ,isStillprime: Boolean): Boolean = {
      if (!isStillprime) false
      else if (t <= 1) true
      else isPrimetailrec(t - 1, (n % t) != 0 && isStillprime)
    }
    isPrimetailrec(n/2,true)
    }

  println(isPrime(2003))
  println(isPrime(629))


  // rule of thumb -> however many recursive calls you have on the same code path that many accumulator you need to have
  //in the tail recursive version of the function
  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int ={
      if(i >=n) last
      else fiboTailrec(i+1,last + nextToLast , last)
    }
   if(n<=2)  1
   else fiboTailrec(2,1,1)
  }
  println(fibonacci(8))
}
