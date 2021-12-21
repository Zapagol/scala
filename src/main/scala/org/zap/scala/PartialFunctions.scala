package org.zap.scala

/**
  * traitPartialFunction[-A, +B] extends (A) => B
  *
  * A partial function of type PartialFunction[A, B] is a unary function where the domain does not necessarily
  * include all values of type A. The function isDefinedAt allows to test dynamically if a value is in the
  * domain of the function.
  *
  * There are some methods to define Partial Functions like case statements, collect method,
  * andThen, orElse ..
  */
object PartialFunctions extends App{

  // using two methods
  val pfResult = new PartialFunction[Double, Double] {
    def isDefinedAt(x: Double): Boolean = x >= 0
    def apply(x: Double) = Math.sqrt(x)
  }

  println(if(pfResult.isDefinedAt(-10)) pfResult(-10))

  // using case
  val numbers = 1 to 20
  val isEven: PartialFunction[Int, Int] = {
    case x if x % 2 == 0 => x
  }

  val evenNumbers = numbers collect isEven
  println(evenNumbers)

  // chaining Partial Function using andThen
  val isOdd: PartialFunction[Int, Int] = {
    case x if x % 2 == 1 => x
  }
  val isPositive: PartialFunction[Int, Int] = {
    case x if x >= 0 => x
  }

  val evenCheck = isPositive andThen isEven
  val oddCheck = isPositive andThen isOdd
  println(numbers.map(x => evenCheck.isDefinedAt(x)))
  println(numbers.map(x => oddCheck.isDefinedAt(x)))
}
