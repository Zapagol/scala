package org.zap.scala.advanced

object Generics {

  def main(args: Array[String]): Unit ={
    genericExampl1()
  }

  def genericExampl1(): Unit ={
    class MyList[A] {
      //use the type A
    }
    class MyMap[Key, Value]

    val listOfIntegers = new MyList[Int]
    val listOfStrings = new MyList[String]

    //generic methods
    object MyList {
      def empty[A]: MyList[A] = ???
    }

    val emptyListOfIterator = MyList.empty[Int]

    // Variance Problem

    class Animal
    class Cat extends Animal
    class Dog extends Animal

    // 1. Co-Variance
    class CovariantList[+A]
    val animal: Animal = new Cat
    val animalList: CovariantList[Animal] = new CovariantList[Cat]

    // 2. In-Variance
    class InvariantList[A]
    val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]
    // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] -- not possible

    // 3. Contra-Variance
    class ContraVariantList[-A]
    val contraVariantList: ContraVariantList[Cat] = new ContraVariantList[Animal]

    class Trainer[-A]
    val trainer: Trainer[Cat] = new Trainer[Animal]

    //bounded Type

  }

  def genericExample2(): Unit ={

    class Fruit
    class Apple extends Fruit
    class Orange extends Fruit
    class Vegetable
    class Tomato extends Vegetable
    class Carrot extends Vegetable

    class Stack[A] {
      private var elements: List[A] = Nil
      def push(x: A) { elements = x :: elements }
      def peek: A = elements.head
      def pop(): A = {
        val currentTop = peek
        elements = elements.tail
        currentTop
      }
    }

    val stackInt = new Stack[Int]
    stackInt.push(1)
    //stackInt.push("String") -- not correct

    val stackFruit = new Stack[Fruit]
    stackFruit.push(new Apple)
    stackFruit.push(new Fruit)
    //stackFruit.push(new Tomato) -- not correct


  }

}
