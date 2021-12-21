//package org.zap.scala.collections
//
///**
//  * Signature of List:
//  *  sealed abstract class List[+A]
//  *
//  *  The List class is a linear, immutable sequence. All this means is that it’s a linked-list that
//  *  you can’t modify. Any time you want to add or remove List elements, you create a new
//  *  List from an existing List.
//  */
//object List extends App {
//
//  //Creating List
//  val ints = List(1,2,3)
//  val names = List("Robert", "John", "Michal")
//  val list = 1 :: 2 :: 3 :: Nil
//
//  val intWithType: List[Int] = List(1,2,3)
//  val namesWithType: List[String] = List("Robert", "John", "Michal")
//
//  // Adding elements to a List
//  /**
//    * Because List is immutable, you can’t add new elements to it. Instead you create a new list by
//    * prepending or appending elements to an existing List. For instance, given this List:
//    */
//
//  val a = List(1, 2, 3)
//  val b = 0 +: a // List(0, 1, 2, 3)
//  val c = a :+ 0// List(1, 2, 3, 0)
//
//  println(b)
//  println(c)
//
//  val b1 = List(-1, 0) ++: a // List(-1, 0, 1, 2, 3)
//  val c1 = a ++ List(-1, 0) // List(1, 2, 3, -1, 0)
//
//  println(b1)
//  println(c1)
//
//  // Loop Over a List
//
//  for(name <- names) println(name)
////  Robert
////  John
////  Michal
//
//  val mainList = List(3, 2, 1)
//  val with4 =    4 :: mainList  // re-uses mainList, costs one :: instance
//  val with42 =   42 :: mainList // also re-uses mainList, cost one :: instance
//  val shorter =  mainList.tail  // costs nothing as it uses the same 2::1::Nil instances as mainList
//
//  // Make a list via the companion object factory
//  val days = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
//
//  // Make a list element-by-element
//  val when = "AM" :: "PM" :: Nil
//
//  // Pattern match
//  days match {
//    case firstDay :: otherDays =>
//      println("The first day of the week is: " + firstDay)
//    case Nil =>
//      println("There don't seem to be any week days.")
//  }
//
//}
