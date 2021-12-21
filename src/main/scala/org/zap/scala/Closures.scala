package org.zap.scala

/**
  * A closure is a function, whose return value depends on the value of one or more variables declared outside
  * this function.
  */
object Closures {

  def main(args: Array[String]): Unit ={
    //println( "multiplier(1) value = " +  multiplier(1) )
    println( "multiplier(2) value = " +  multiplier(2) )
    println(add(10, 20))
    println(addEnhanced(10, 20))
  }
  val factor = 3
  //This function depends on factor which is outside the function
  val multiplier = (x: Int) => x * factor

  //This is not closure. This function not depends on any variables which are are outside function
  val add = (x: Int, y: Int) => x + y

  //Now we can this function as closure as it depends on variable 'c' which is outside the function
  val c = 100
  val addEnhanced = (x: Int, y: Int) => x + y + c

}
