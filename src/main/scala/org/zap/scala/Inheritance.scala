package org.zap.scala

/**
  * - Subclass inheritate non private fields and functions.
  * - Protected modifier fields and functions can accessible inside subclass only.
  * - Private modifier fields and functions can't accessible inside subclass.
  * It can access in super class only.
  */
object Inheritance {

  // Single class Inheritance
  class ArithmeticOperations{
    val arithmeticOperators = "+,-,*"
    protected def sum(a: Int, b: Int) = a + b // Public by default
    def minus(a: Int, b: Int) = a - b
    private def multiply(a: Int, b: Int) = a * b
  }

  class Calculator extends ArithmeticOperations {
    def extendedSum(a: Int, b: Int) = sum(a, b)
    // multiply(10, 10) -- not possible
  }

  val calc = new Calculator
  println("Sum = " + calc.extendedSum(10,20))
  //println("Minus = " + calc.sum(10,20)) -- not possible!
  //println("Multiply = " + calc.multiply(10, 10)) -- not possible
  println("Minus = " + calc.minus(100,20))

  //overriding
  class AttitudeCalc extends ArithmeticOperations{
    override def minus(a: Int, b: Int): Int = {
      println("Super class minus = " + super.minus(a, b))
      b - a
    }
    override val arithmeticOperators: String = "/, %,"
  }

  val attitudeCalc = new AttitudeCalc
  println(attitudeCalc.minus(20, 10))
  println(attitudeCalc.arithmeticOperators)

  // Type Substitution - Polymorphism
  val unknowCalc: ArithmeticOperations = new AttitudeCalc
  println(unknowCalc.minus(20, 100))

  // Overriding - Providing different implementation
  // Overloading - Same name with different signatures

  // super - It is used to access super class members.

  // Preventing overriding
    // 1. final can use on member
    // 2. final on entire class
    // 3. seal the class(keyword 'sealed') = extend the classes in this file and prevent extension in other files
}
