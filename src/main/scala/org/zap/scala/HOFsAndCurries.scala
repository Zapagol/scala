package org.zap.scala

import org.apache.spark.sql.catalyst.expressions.aggregate.Max

/**
  * Higher Order Function(HOF) : functions take other functions as parameters or return a
  * function as a result.
  *
  * HOF's available in scala collections
  *   - map
  *   - filter
  *   - flatmap and etc..
  *
  */
object HOFsAndCurries extends App {

  // Higher Order Function(HOF) : A function which take a function as a parameter or which return a function
  // map. flatmap, filter and etc are HOF
  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null

  // function that applies a function n times over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  // nTimes(f, n, x) = f(f(f ... f(x)))) = nTimes(f, n-1, f(x))

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if(n <= 0) x
    else nTimes(f, n-1, f(x))
  }

  // Curried function
  val adder: Int => Int => Int = (x: Int) => (y: Int) => x + y
  val add = adder(5)
  println(adder(10))
  println(adder(5)(10))

  // function with multiple parameter list
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormatter: Double => String = curriedFormatter("%4.2f")
  val preciseFormatter: Double => String = curriedFormatter("%10.8f")

  println(standardFormatter(Math.PI))
  println(preciseFormatter(Math.PI))

  // Coercing methods into functions : Methods as argument to HOF's
  def doubleToInt(x: Double): Int = x.toInt

  def convertDoubleToIntList(doubleList: List[Double]): List[Int] = {
    doubleList.map(doubleToInt)
  }

  val doubleList = List(10.5, 20.1, 99.9)
  println(convertDoubleToIntList(doubleList))

  //Function that accepts function
  def stringToAny(stringList: List[String], converter: String => Any): List[Any] ={
     stringList.map(converter)
  }

  val stringToInt = (z: String) => z.toDouble.toInt
  val stringList = List("1.4","2.1","3.7")
  println("String to Int = " + stringToAny(stringList, stringToInt))

  val stringToDouble = (z: String) => z.toDouble
  println("String to Double = " + stringToAny(stringList, stringToDouble))

  // Function that return function

  def returnFunction(): List[String] => List[Int] = {
    stringList => stringList.map(_.length)
  }
  val stringList1 = List("Zomato", "Swiggy", "Uber Eats")
  val stringLengthFun = returnFunction
  println(stringLengthFun(stringList1))
  println(returnFunction()(stringList1))

  // Function which takes a function and return function

  def takeReturnFunction(stringList: List[String], converter: String => Double): List[Double] => List[Int] = {
    stringList.map(converter)
    doubleList => doubleList.map(_.toInt)
  }

  val doubleStringList = List("10.3", "20.1", "30.1")
  val fun1 = takeReturnFunction(doubleStringList, (x: String) => x.toDouble)
  println(fun1(List(10.1, 20.1, 30.1)))

  // (x: String) => x.toDouble -- Anonymous function
  println(takeReturnFunction(doubleStringList, (x: String) => x.toDouble)(List(10.2,20.2,30.2)))

  //Function that accepts function
  def anyToString(stringList: List[Any], converter: Any => String): List[Any] ={
    stringList.map(converter)
  }

  val stringToInt1 = (z: Any) => z.toString
  val stringList2 = List("1.4","2.1","3.7")
  println("String to Int = " + stringToAny(stringList2, stringToInt1))

  def calulator(f: (Int, Int) => Int, a: Int, b: Int): Double ={
    f(a, b)
  }
  val sum = (x: Int, y: Int) => x + y
  val minus = (x: Int, y: Int) => x - y
  val multiply = (x: Int, y: Int) => x * y

  println(calulator(multiply , 10, 10))
  def addition(f: (Int, Int) => Int,a: Int, b:Int): Int = f(a,b)

  val squareSum = (x: Int, y: Int) => (x*x + y*y)
  val cubeSum = (x: Int, y: Int) => (x*x*x + y*y*y)
  val intSum = (x: Int, y: Int) => (x + y)

  val squaredSum = addition(squareSum, 1, 2)
  val cubedSum = addition(cubeSum, 1, 2)
  val normalSum = addition(intSum, 1, 2)

  def calculator(f:(Int, Int) => Any, a: Int, b: Int): Unit = {
    println(f(a, b))
  }

  val addition = (a: Int, b: Int) => a + b
  val subtraction = (a: Int, b: Int) => a - b
  val multiplication = (a: Int, b: Int) => a * b

  calculator(addition, 10, 20)
  calculator(subtraction, 10, 20)
  calculator(multiplication, 10, 10)

  def exec(f:Int => Unit){
     f(10)
  }

  val plusTen = (i: Int) => println(i + 10)
  exec(plusTen)

}
