package lectures.part1basics

object L8DefaultArgs extends App {

  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n - 1, n * acc)

  val fact10 = trFact(10, 2)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit =
    println("saving picture")

  savePicture(width = 800)

  /*
    1. pass in every leading argument
    2. name the arguments
   */

  savePicture(height = 600, width = 800, format = "bmp")

  /**
   * Takeaways:
   * -> When 99% of the time we call a function with the same params,
   *    we can assign that value as default value in function definition itself
   * -> Try to make preceding element in the method definition with the default value
   * -> If in case you need to make the leading element with the default value
   *    please pass value with the argument name in the method call
   * -> If you pass the value with arg name in the method call then you have few liberties:
   *    a) you can pass args in any order
   *    b) for the args you are not passing the value it is going to use default value for it.
   *
   * Example:
   * def greet(name: String = "Superman", age: Int = 10): String = {...}
   * -> greet(age = 5)
   * -> greet(name = "sally", age = 5)
   * -> greet(age = 5, name = "dog")
   */
}