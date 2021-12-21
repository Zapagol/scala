package org.zap.scala.collections

object Sequences extends App {

  // Seq
  val aSeq = Seq(3,10,5,9)
  println(aSeq)

  println(aSeq.reverse)
  println(aSeq.sorted)
  println(aSeq(1))
  println(aSeq ++ Seq(1,2,3))
  println(aSeq.toArray)

  // Ranges
  val aRange1: Seq[Int] = 1 to 5
  val aRange2: Seq[Int] = 1 until 5

  (1 to 5).foreach( x => println("Hello Scala"))

  // List : Signature
  // sealed abstract class List[+A]
  // case object Nil extends List[Nothing]
  // case class ::[A](val hd: A, val tl:List[A] extends List[A]

  val intList = List(1,4,10,8)
  val prependedList1 = 20 :: intList
  val prependedList2 = 20 +: intList
  println(prependedList1)
  println(prependedList2)

  // val postPendedList = intList :: 30 // doesn't work
  val postPendedList = intList :+ 30
  println(postPendedList)

  val nTimeList = List.fill(5)("Hello Scala")
  println(nTimeList)

  println(intList.mkString(","))

  // arrays
  val numbers = Array(1,3,2,5)

  val nTimesElements = Array.ofDim[String](3)
  println(nTimesElements)

  // mutation

  numbers(3) = 10
  println(numbers)

  // array  and seq
  val numberSeq: Seq[Int] = numbers // Implicit conversion
  println(numberSeq)

}
