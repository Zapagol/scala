package org.zap.scala

/**
  * An object is a class that has exactly one instance. It is created lazily when it is referenced, like a lazy val.
  *
  * The word object has a dual meaning in Scala.In Java,object is a instance of a class but in Scala
  * object is keyword also.
  *
  * - Object Casting: Use the 'asInstanceOf' method to cast an instance to the desired type.
  *   Syntaxt : val obj1 = obj.asInstanceOf[class]
  *
  * - Create Object Instance without using `new` keyword
  *   1. Create a companion object for your class, and define an apply method in the companion
  *   object with the desired constructor signature.
  *   2. Define your class as case class.
  *
  */
object Objects extends App{

  //Object casting
  val double: Double = 10.5;
  val int = double.asInstanceOf[Int]
  println("Cast - Double to Int = " + int)

  // Scala doesnot have class lavel functionality ("statics")

  object IndiaCricketTeam { // type + it's only instance
    val boardOfControl = "BCCI"
    def canHostWorldCup : Boolean = false
  }

  class IndiaCricketTeam {
    // Instance level functionality
  }

  // Creating companion object with an apply method.
  class Employee{
    def disPlay(): Unit ={
      println("Hi, I have a Companion Object -->")
    }
  }
  object Employee{
    def apply: Employee = {
      var emp = new Employee()
      //emp = emp.disPlay()
      emp
    }
  }
  val employee = Employee

  // COMPANION

  println(IndiaCricketTeam.boardOfControl)
  println(IndiaCricketTeam.canHostWorldCup)

  //Scala object = Singleton Instance
  val indiaCricket1 = IndiaCricketTeam
  val indiaCricket2 = IndiaCricketTeam

  println(indiaCricket1 == indiaCricket2)

  val indiaCricket3 = new IndiaCricketTeam
  val indiaCricket4 = new IndiaCricketTeam

  println(indiaCricket3 == indiaCricket4)


}
