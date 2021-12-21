package org.zap.scala

/**
  * When to use abstract classes in scala
  *   1. If we want to create a base class that requires constructor arguments.
  *   2. The code will be called from JAVA code
  *
  * Abstract classes can not be initiated.
  *
  * Properties:
  *
  * 1. As in JAVA, we can't create the instance of abstract class.
  * val animal = new Animal("") // Class name Animal is abstract, cannot be instantiated.
  *
  * 2. abstract class can contain final methods. These methods cannot be overridden.
  */
object Abstarct extends App{

  //this won't compile
  //trait Animal(name: String)

  abstract class Animal(name: String){}

  //abstract
  abstract class ArithmeticOperators{
    // abstract field
    val arithmeticOperators: String
    // abstract method
    def sum(a: Int, b: Int): Int
    // non-abstract method
    def minus(a: Int, b: Int): Int = a - b
  }

  class Calculator extends ArithmeticOperators{
    val arithmeticOperators: String = "+, -, *, /"
    def sum(a: Int, b: Int): Int = a + b
  }

  //abstract class with parameters
  abstract class Bank (ifscCode: String) {
    def printIfscCode(): Unit = { println(s"IFSC Code of bank is $ifscCode") }   // concrete implementation
  }

  class HDFCBank(ifscCode: String) extends Bank(ifscCode) {}

  val bank = new HDFCBank("HDFC000177")
  println(bank.printIfscCode())

  //Properties

  // 1. As in JAVA, we can't create the instance of abstract class.
  //val animal = new Animal("") // Class name Animal is abstract, cannot be instantiated.

  // 2. abstract class can contain final methods. These methods cannot be overridden.
  abstract class Dad(){
    final def useCreditCard(number: Int): Unit ={
      println(s"Credit card number is $number")
    }
  }

  class Son extends Dad{
    //compilation error - method useCreditCard can't override final methods
//    override def useCreditCard(number: Int): Unit ={
//      println("I can use dad's credit card")
//    }
  }

  val son = new Son
  son.useCreditCard(26517)

  /*
    traits vs abstract
    1. traits don't have constructor parameters
    2. a class can inherite multiple traits
    3. traits = behavior, abstract = thing
   */
}
