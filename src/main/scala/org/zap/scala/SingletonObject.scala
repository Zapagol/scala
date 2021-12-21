package org.zap.scala

/**
  * One way in which Scala is more object oriented than JAVA is that classes cannot have
  * Static members.Instead, scala has Singleton Object.
  *
  * A singleton object definition looks like a class definition, except instead of the keyword
  * class you use the keyword object.
  *
  * When a singleton object shares the same name with a class, it is called that
  * class's companion object.
  *
  * One difference between classes and singleton objects is that singleton objects cannot take parameters,
  * whereas classes can.Because you can't instantiate a singleton object with the new keyword, you have
  * no way to pass parameters to it.
  */

object SingletonObject {

  val singleTonVariable = "Hi I am Singleton Variable"

  /**
    * Singleton function which calculates the factorial of number.
    * @param number
    * @return
    */
  def factorial(number: Int): Int ={
    if(number == 0 ) 1
    else number * factorial(number - 1)
  }

  //Main method
  def main(args: Array[String]): Unit ={
    println(factorial(4))
  }
}
