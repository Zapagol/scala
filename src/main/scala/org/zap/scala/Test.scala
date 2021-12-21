package org.zap.scala

import scala.concurrent.Future

object Test extends App {

  println("strawberries".substring(2, 5))
  val map = Map("abc" -> "abc", "a"->"b").toList

  println("a".equals("a"))
  println("a" == "a")

  val y = List("a", "b")
  println(y :: List("c"))

  val a = Array(1, 2, 3)
  a{0} = 10

  a.foreach(println)
}
