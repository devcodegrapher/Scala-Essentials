package lectures.part2oop

object L18Generics extends App {

  class MyList[A] {
    // use the type A
  }

  class MyMap[Key, Value]

  val listofIntegers = new MyList[Int]
  val listofStrings = new MyList[String]

  // generics methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListofIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // que -> if a cat extends animal does the list of cat also extends list of animal
  // 1  .  ans -> yes , List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog)  ??? HARD QUESTION.

  //2. No = Invariance
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class cage[A <: Animal](animal: A) // this means A can be withe subclass of animal and super class of animal
  val cage = new cage(new Dog)
  class Car
  //  val newCage = new cage(new Car)  -> it will throw error as car is not either sub or super class of a Animal class

  // class cage[A>:Animal] (animal:A)  -> this means it will only accept super type of animal

}
