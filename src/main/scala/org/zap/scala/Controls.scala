package org.zap.scala

object Controls extends App{

  val stringList = List("India", "USA", "UK", "Russia")
  val intList = List(10, 20, 30, 40)

  // 1. Basic For loop
  for( n <- stringList) println(n)
//  India
//  USA
//  UK
//  Russia

  // 2. Using Generators

  // 2.1 Single Generator
  for(n <- 10 to 15) println(n)
//  10
//  11
//  12
//  13
//  14
//  15

  // 2.2 Multiple Generator
  for(x <- stringList; y <- intList) println(x + y)
//  India10
//  India20
//  India30
//  India40
//  USA10
//  USA20
//  USA30
//  USA40
//  UK10
//  UK20
//  UK30
//  UK40
//  Russia10
//  Russia20
//  Russia30
//  Russia40

  // 3. With guards

  // 3.1 With Single Guard
  for(i <- 1 to 10 if(i % 2) == 0) println(i)
//  2
//  4
//  6
//  8

  // 3.2 With Several guards

  for(x <- 1 to 20 if x > 10 if(x % 2) == 0) println(x)
//  10
//  12
//  14
//  16
//  18
//  20

  // 4. with yields : for/yield is the same as a basic map

  for(x <- stringList) yield println(x.toUpperCase)

//  INDIA
//  USA
//  UK
//  RUSSIA

  for(x <- stringList) yield println(x.length)
//  5
//  3
//  2
//  6

  println(stringList.map(_.toUpperCase))

  // 5. with Counters
  // until doesn't print last element
  for(i <- 0 until 5) println(i)

//  0
//  1
//  2
//  3
//  4

  for(i <- 0 until "Scala".length) println(i)

//  0
//  1
//  2
//  3
//  4

  // 6. with zipWithIndex

  for ((name, count) <- stringList.zipWithIndex) {
    println(s"$count is $name")
  }

//  0 is India
//  1 is USA
//  2 is UK
//  3 is Russia

  // 7. Scala Map
  val capitals = Map("India" -> "Delhi", "USA" -> "Washington DC", "Japan" -> "Tokyo")

  for((k,v) <- capitals){
    println(s"Country: $k, Capital City: $v")
  }

//  Country: India, Capital City: Delhi
//  Country: USA, Capital City: Washington DC
//  Country: Japan, Capital City: Tokyo

  // 8. with by keyword : The by keyword is used to skip the iteration.

  for(i<-1 to 10 by 2){
    println(i)
  }

//  1
//  3
//  5
//  7
//  9

  class A {
    def hello = "hello from A"
  }
  class B {
    def welcome = "Welcome from B"
  }
  // We can't extend more than 1 class.
//  class c extends A with B{
//
//  }
  trait Z {
    def welCome = "Welcome from Z"
  }

  class C extends A with Z{

  }

  //This won't work. We should extend class first and than trait.
//  class D extends Z with A{
//
//  }
}
