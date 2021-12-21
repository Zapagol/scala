package org.zap.scala

/**
  * When you give only subset of the parameters to the function, the result of the expression is
  * a partially applied function.
  */
object PartiallyAppliedFunctions extends App {

  val sum = (a: Int, b: Int, c: Int) => a + b + c

  //Normal function
  println(sum(10, 10, 10)) // 30

  //Partially applied function. Passed only subset of the function
  println(sum(10, 10, _:Int)) // <function1>
  println(sum(10, _:Int, _:Int)) // <function2>
  val f = sum(10, 10, _:Int)
  println(f(10)) // 30

}
