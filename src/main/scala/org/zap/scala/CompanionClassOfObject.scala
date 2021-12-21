package org.zap.scala

class CompanionClassOfObject {

  private val privateValClass = "Hi I am Private variable in Companion class"

  def recursiveFunc(n: Int) : Int = {
    if(n == 0 ) 1
    else n * recursiveFunc(n-1)
  }
}

/**
  * Class and it's companion object should be in the same source file.
  * The class is called companion class of singleton object.Companion Object of class CompanionClassOfObject.
  *
  * A class and it's companion object can access each other's private members.
  */
object CompanionClassOfObject {

  private val privateValObject = "Hi I am Private variable in Companion Object"

  def tailRecursiveFunc(n: Int, accumulator: Int = 1) : Int = {
    if(n <= 1) accumulator
    else tailRecursiveFunc(n-1, n * accumulator)
  }

}

object mainClass {
  def main(args: Array[String]): Unit ={
    val companionClaa = CompanionClassOfObject
  }
}
