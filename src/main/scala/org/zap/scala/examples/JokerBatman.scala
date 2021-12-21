package org.zap.scala.examples

import java.util.Scanner
import scala.io.StdIn.readLine

object JokerBatman extends App {
  val scanner = new Scanner(System.in)
  var testCases = scanner.nextInt()
  val firstName = readLine().toInt
  println(firstName)
  while (testCases > 0) {
    val map = scala.collection.mutable.Map[Integer, Integer]()
    val numberOfColors = scanner.nextInt()
    val numberOfList = scanner.nextInt()
    val stripLength = scanner.nextInt()
    for (i <- 1 to numberOfList) {
      var size = scanner.nextInt()
      while (size > 0) {
        val color = scanner.nextInt()
        map.put(color, i)
        size = size - 1
      }
    }
    val colors = new Array[Integer](stripLength)
    for (i <- 0 until stripLength) {
      colors(i) = scanner.nextInt()
    }
    var current = map.get(colors(0))
    var count = 1
    for (i <- 1 until stripLength) {
      val currentList = map.get(colors(i))

      if (currentList != current) {

        count = count + 1
        current = currentList
      }

    }
    println(count)
    testCases -= 1
  }
}
