package org.zap.scala


/**
  * Recursive function is a function which calls itself.
  *
  * Tail recursion is a function where the last action is the invocation of a recursive function.
  */
object Recursion {

  def main(args: Array[String]): Unit ={
    factorial(10)
    //println(factorial(5000)) // It throws stackOverflow error as stack memory filled.

    println(tailRecursion(5000))
    println(stringContination("Hello", 5, ""))

    println(fibonacciRecursion(8))
    println(fibonacciTailRecursion(8))
  }

  def factorial(n: Int) : Int = {
    if(n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }
  }

  /**
    * When you need loop, use tail recursion function.
    *
    * @param n
    * @return
    */
  def tailRecursion(n: Int) : BigInt = {
    def factHelper(x: Int, accumulator: BigInt) : BigInt = {
      if(x <= 1) accumulator
      else factHelper(x-1, x * accumulator)
    }
    factHelper(n, 1)
  }

  def stringContination(stringValue: String, n: Int, accumulator: String) : String = {
    if( n<= 0) accumulator
    else stringContination(stringValue, n-1 ,stringValue + accumulator)
  }

  def fibonacciRecursion(n: Int): Int = {
    if(n > 1) fibonacciRecursion(n-1) + fibonacciRecursion(n-2)
    else n
  }

  def fibonacciTailRecursion(n: Int): Int = {
    if(n > 1) {
      def fibIter(prev: Int, current: Int, n: Int): Int =
        if (n == 0) current
        else fibIter(current, prev + current, n - 1)
      fibIter(1, 1, n-2)
    }else n

  }
}
