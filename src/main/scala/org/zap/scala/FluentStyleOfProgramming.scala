package org.zap.scala

/**
  * Fluent Style of programming also known as method chaining.
  *
  * To support this style of programming
  *   1. If your class can be extended, specify as the return type of fluent style
  * this.type methods.
  *   2. If you’re sure that your class won’t be extended, you can optionally return
  * from this your fluent style methods.
  */
object FluentStyleOfProgramming extends App{

  class Calculator{
    protected var result = 0

    def add(a: Int, b: Int): this.type ={
      this.result = a + b
      this
    }
    def multiply(a: Int): this.type = {
      this.result = result * a
      this
    }
    def substract(a: Int): this.type = {
      this.result = result - a
      this
    }
    def get(): Unit ={
      println(result)
    }

  }
  val calc = new Calculator
  calc.add(10,10)
    .multiply(20)
    .substract(50)
    .get()

}
