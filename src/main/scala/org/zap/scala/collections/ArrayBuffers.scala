//package org.zap.scala.collections
//
//import scala.collection.mutable.ArrayBuffer
//
///**
//  * To use an `ArrayBuffer` you must first import it:
//  *
//  * import scala.collection.mutable.ArrayBuffer
//  *
//  */
//object ArrayBuffers extends App{
//
//  // Create empty arrayBuffer
//  val ints = ArrayBuffer[Int]()
//  val names = ArrayBuffer[String]()
//
//  //Add elements into it
//  ints += 1
//  ints += 2
//
//  names += "Robert"
//  names += "Michal"
//
//  println(ints) // ArrayBuffer(1, 2)
//  println(names) // ArrayBuffer(Robert, Michal)
//
//  // create an ArrayBuffer with initial elements like this:
//  val nums = ArrayBuffer(1, 2, 3)
//
//  // add one element
//  nums += 4
//
//  // add multiple elements
//  nums += 5 += 6
//
//  // add multiple elements from another collection
//  nums ++= List(7, 8, 9)
//
//  // You remove elements from an ArrayBuffer with the -= and --= methods:
//  // remove one element
//  nums -= 9
//
//  // remove multiple elements
//  nums -= 7 -= 8
//
//  // remove multiple elements using another collection
//  nums --= Array(5, 6)
//
//  // More ways to work with ArrayBuffer
//
//  val a = ArrayBuffer(1, 2, 3)         // ArrayBuffer(1, 2, 3)
//  a.append(4)                          // ArrayBuffer(1, 2, 3, 4)
//  a.append(5, 6)                       // ArrayBuffer(1, 2, 3, 4, 5, 6)
//  a.appendAll(Seq(7,8))                // ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8)
//  a.clear                              // ArrayBuffer()
//
//  val b = ArrayBuffer(9, 10)           // ArrayBuffer(9, 10)
//  b.insert(0, 8)                       // ArrayBuffer(8, 9, 10)
//  b.insertAll(0, Vector(4, 5, 6, 7))   // ArrayBuffer(4, 5, 6, 7, 8, 9, 10)
//  b.prepend(3)                         // ArrayBuffer(3, 4, 5, 6, 7, 8, 9, 10)
//  b.prepend(1, 2)                      // ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//
//  val c = ArrayBuffer.range('a', 'h')  // ArrayBuffer(a, b, c, d, e, f, g)
//  c.remove(0)                          // ArrayBuffer(b, c, d, e, f, g)
//  c.remove(2, 3)                       // ArrayBuffer(b, c, g)
//
//  val d = ArrayBuffer.range('a', 'h')  // ArrayBuffer(a, b, c, d, e, f, g)
//  d.trimStart(2)                       // ArrayBuffer(c, d, e, f, g)
//  d.trimEnd(2)                         // ArrayBuffer(c, d, e)
//}
