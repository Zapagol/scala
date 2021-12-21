package org.zap.scala

/**
  * Call By Value: Value is computed before call and hence same value is used everywhere.
  * Call By Name: Expression is passed literally and hence expression is evaluated at every use within
  */
object CallByValueVsCallByName {

  def main(args: Array[String]): Unit = {
    callByValue(System.nanoTime())

    // call by value = 354637810847900
    // call by value = 354637810847900

    callByName(System.nanoTime())

    // call by name = 354638490218700
    // call by name = 354638490285800

    printFirst(infinite(), 34) // StackOverflow error
    printFirst(34, infinite()) // 34
  }

  def callByValue(x: Long): Unit ={
    println("call by value = " + x)
    println("call by value = " + x)
  }

  def callByName(x: => Long): Unit ={
    println("call by name = " + x)
    println("call by name = " + x)
  }

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)
}
