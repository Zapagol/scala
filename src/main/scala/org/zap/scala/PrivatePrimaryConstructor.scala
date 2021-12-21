package org.zap.scala

/**
  * To make the primary constructor private, insert the private keyword in between the
  * class name and any parameters the constructor
  *
  * a private one-argument primary constructor
  */
class PrivatePrimaryConstructor private (name: String){
  override def toString: String = s"$name : I am private primary constructor"
}

object PrivatePrimaryConstructor{

  //A simple way to enforce the Singleton pattern in Scala is to make the primary constructor
  //private, then put a getInstance method in the companion object of the class
  val privatePrimaryConstructor = new PrivatePrimaryConstructor("Scala")
  def getInstance = privatePrimaryConstructor
}


object Main {
  def main(args: Array[String]): Unit = {
    //This won't compile.
    // Error: No constructor accessed from here.
    //val p = new PrivatePrimaryConstructor("Scala")

    //This works
    val privatePrimaryConstructor = PrivatePrimaryConstructor.getInstance
    println(privatePrimaryConstructor)

  }

}

