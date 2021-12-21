package org.zap.scala

/**
  * In Scala, a tuple is a value that contains a fixed number of elements,
  * each with a distinct type. Tuples are immutable.
  *
  * Tuples are especially handy for returning multiple values from a method.
  *
  * To represent tuples, Scala uses a series of classes: Tuple2, Tuple3,
  * etc., through Tuple22. Each class has as many type parameters as it has elements.
  */
object Tuples extends App {

  // tuple with 2 elements
  // The inferred type of ingredient is (String, Int), which is shorthand for Tuple2[String, Int].
  val google = ("Sundar Pichai", 1998)

  // Accessing the elements
  // One way of accessing tuple elements is by position. The individual elements are named _1, _2

  println(google._1) // Sundar Pichai
  println(google._2) // 1998

  // Pattern Matching
  val (ceo, founded) = google
  println(ceo)
  println(founded)

  val planets =
    List(("Mercury", 57.9), ("Venus", 108.2), ("Earth", 149.6),
      ("Mars", 227.9), ("Jupiter", 778.3))
  planets.foreach{
    case ("Earth", distance) =>
      println(s"Our planet is $distance million kilometers from the sun")
    case _ =>
  }

  val numPairs = List((2, 5), (3, -7), (20, 56))
  for ((a, b) <- numPairs) {
    println(a * b)
  }

}
