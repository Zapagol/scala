package org.zap.scala

/**
  * A function which does not contain a name is known as an anonymous function.
  */
object AnonymousFunction extends App {

  val doubler1: Int => Int = new Function[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }
  val addition: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(x: Int, y: Int): Int = x + y
  }

  println(doubler1(5))

  val concatinater: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String) = a + b
  }

    println(concatinater("Hello", "Scala"))

  // Anonymous Function(Lambda)

  // All are same
  val doubler2 = (x: Int) => x * 2
  val doubler3: Int => Int = (x: Int) => x * 2
  val doubler4: Int => Int = x => x * 2
  // val doubler5 = x => x * 2 -- not possible

  println(doubler2(10))
  println(doubler3(10))
  println(doubler4(10))

  // Multiple Params
  val multiplier: (Int, Int) => Int = (a: Int, b: Int) => a * b
  val multiplier1: (Int, Int) => Int = (a, b) => a * b
  val multiplier2 = (a: Int, b: Int) => a * b
  println(multiplier(10, 10))
  println(multiplier1(10, 10))
  println(multiplier2(10, 10))

  // No Params

  val noParams: () => Int = () => 10

  println(noParams) // <function0> - this id function itself
  println(noParams()) // 10 - call

  // curly braces with Lambda

  val doubleToInt = { x: Double =>
    x.toInt
  }

  println(doubleToInt(2.6))

  // More Syntatic

  val incrementer1: Int => Int = (x: Int) => x + 1
  val incrementer2: Int => Int = _ + 1 // Both are same

  println(incrementer1(10))
  println(incrementer2(10))

  val adder1: (Int, Int) => Int = (a: Int, b: Int) => a + b
  val adder2: (Int, Int) => Int = _ + _ // both are same

  println(adder1(10,20))
  println(adder2(10,20))

  val curriedAdder = (x: Int) => (y: Int) => x + y
  println(curriedAdder(10)(20))

  //partially applied functions. It has many advantages.
  val sum = (a: Int, b: Int) => a + b
  val f2 = sum
  val f1 = sum(10, _: Int)
  println(f2)
  println(f1)
  println(f1(30))

  // Function that return function.
  def greeting(language: String) = (name: String) => {
    language match {
      case "English" => s"Hello, $name"
      case "Hindi" => s"Namaste, $name"
      case _ => s"Welcome $name"
    }
  }

  val hello = greeting("English")
  println(hello("Chandrayan 2"))

  //creating partial functions.
  /*
    A partial function of type PartialFunction[A, B] is a unary function where the domain
    does not necessarily include all values of type A. The function isDefinedAt allows [you]
    to test dynamically if a value is in the domain of the function.
    Signature of Partial Function:
      trait PatialFunction[-A, +B] extends (A) => B
   */

  val divide = new PartialFunction[Int, Int] {
    override def apply(v1: Int): Int = 20 / v1
    override def isDefinedAt(v1: Int): Boolean =  v1 != 0
  }

  println(divide.isDefinedAt(1))
  println(divide.isDefinedAt(0))
  println(divide(10))
  println(if(divide.isDefinedAt(0))divide(0))
}
