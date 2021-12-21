package org.zap.scala

/**
  * Currying is the process of converting a function with multiple arguments into a sequence of functions that
  * take one argument. Each function returns another function that consumes the following argument.
  */
object Currying {

  def main(args: Array[String]): Unit = {
    val sbc = List(List(1, 2), List(3, 4), List(5, 6))
    val xyz = sbc.map{x =>
      x.map(z => z + 1)
    }
    println(sbc)
    println(xyz)
    println(sum(10, 20))
    println(curriedSum(10)(20))

    println(multiply(10, 10))
    println(curriedMultiply(10)(10))

    println(curriedSubstract(20))
    val c1 = curriedSubstract(20)
    println(c1(10))
  }

  // Normal function
  val sum = (x: Int, y: Int) => x + y
  // Curried function
  val curriedSum = (x: Int) => (y: Int) => x + y

  //Normal method
  def multiply(a: Int, b: Int): Int = a * b
  //Curried method
  def curriedMultiply(a: Int)(b: Int): Int = a * b

  val substract = (x: Int, y: Int) => x - y
  val curriedSubstract = (x: Int) => (y: Int) => x - y




}
