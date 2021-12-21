package org.zap.scala

object Operators {

  case class Company(name: String, ceo: String)

  def main(args: Array[String]): Unit ={
    infixNotation()
    postfixNotation()
    prefixNotation()
    objectEquality()
  }

  class Movie(name: String){
     def rating(imdbRating: Double): String = s"Movie name = $name"
     def movieCollection(collection: Long): String = s"Collection of movie $name is $collection billion"
     def unary_+ : String = s"Name of the movie is $name"

     def apply(): String = s"Name of the movie is $name"
  }

  /**
    * Method to invoke sits between the object and the parameter (or parameters) you wish to pass to
    * the method.
    *
    * Operators are written in-between their operands.
    */
  def infixNotation(): Unit ={

    val infix1 = 10 + 5 // Scala invokes 10.+(5)
    println(infix1)
    //infix1: Int = 15

    val infix2 = 10.+(5)
    println(infix2)
    //infix2: Int = 15

    val stringValue = "Hello, Scala"
    val infix3 = stringValue indexOf 'S'
    println(infix3)
    //infix3: Int = 7

    val infix4 = stringValue indexOf ('l', 6)
    println(infix4)
    //infix4: Int = 10

    val infix5 = stringValue charAt 7 // Scala invokes stringValue.charAt(7)
    println(infix5)
    //infix5: Char = S

    val list = List(1,2,3,4)
    val infix6 = list slice(1, 3)
    println(infix6)
    //infix6: List[Int] = List(2, 3)

    val movie1 = new Movie("Avatar")

    println(movie1.rating(7.8))
    println(movie1 rating 7.8)

    println(movie1.movieCollection(2787965087L))
    println(movie1 movieCollection 2787965087L)

  }

  /**
    * A postfix operator can be an arbitrary identifier. The postfix operation e;op is interpreted as e.op.
    * Scala allows methods that take no arguments to be invoked using postfix notation.
    *
    */
  def postfixNotation(): Unit ={
    val stringValue = "Hello, Welcome to Scala!"
    val postfix1 = stringValue toUpperCase

    println(postfix1)
    //postfix1: String = "HELLO, WELCOME TO SCALA!"

    val postfix2 = stringValue length

    println(postfix2)
    //postfix2: String = 24

    val listOfString = List("Engalnd", "Australia", "India")
    val postfix3 = listOfString toArray

    println(postfix3)
    //postfix3: Array[String] = Array(Engalnd, Australia, India)

    val movie3 = new Movie("Inception")
    println(movie3.apply())
    println(movie3())
  }

  def prefixNotation(){

    // Uniray operators are methods.
    val x = -1 // Equivalent to 1.uniray_-
    val y = 1.unary_-
    //uniray_prefix only work with - + ~ !

    val movie2 = new Movie("Avengers EndGame")
    println(movie2.unary_+)
    println(+movie2)
  }

  /**
    * To compare two objects for equality, you can use either == or its inverse !=.
    * These operations apply to all the objects.
    *
    * It return true as long as their contents are the same.Their equals method is written to be based on contents.
    */

  def objectEquality(): Unit ={

    println(5 == 10) // false
    println(5 != 10) // true

    val list1 = List(1,2,3,4)
    val list2 = List(1,2,10,8)

    // It can apply to all objects
    println(list1 == list2) // false

    val caseClass1 = Company("Google", "Sundar Pichai")
    val caseClass2 = Company("Google", "Sundar Pichai")
    val caseClass3 = Company("Google", "Lary Page")

    println(caseClass1 == caseClass2) // true
    println(caseClass1 == caseClass3) // false

    val concaninateString = "Hello, Welcome" + " to Scala"
    val normalString = "Hello, Welcome to Scala"

    println(concaninateString == normalString) // true

    val hello1 = "hello"
    val hello2 = "Hello"

    println(hello1 == hello2) // false

  }

}
