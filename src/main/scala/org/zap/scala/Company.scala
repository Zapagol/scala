package org.zap.scala

/**
  * Class : Blueprint for object. Class holds fields and methods called members.
  *
  *   Class members :
  *     1. Fields : val or vars are variables. Fields holds state/behaviour of an object.
  *     2. Methods : define with def, contains executable code. Methods use the data to do
  *     the computational work of the object.Method parameter in scala are vals.
  *
  *  - One way in which Scala is more object-oriented than Java is that classes in
  * Scala cannot have static members.Instead scala has Singleton object.
  *
  */
class Company {

  //Class definition goes here.

  // Fields
  val companyName = "XYZ" // val - Immutable
  var numberOfEmployees = 55000 // va - MuTable
  private var sum = 0

  //Method
  def display(): Unit ={
    println(s"Comapany Name = $companyName and Number of Employee(2018) = $numberOfEmployees")
  }

  //Method parameters in Scala are vals not vars.
  def calculateSum(a: Int, b: Int) : Int = {
    // a = 10  // This won't compile. Reassignment to val
    sum = a+b
    sum
  }

}
