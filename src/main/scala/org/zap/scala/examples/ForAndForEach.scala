package org.zap.scala.examples

/**
  * 1. for loop that iterates over a collection is translated to a foreach method call.
  * 2. for loop with Guards translated to a sequence of withfilter followed by foreach method call.
  * 3. for loop with Yields translated to map method call.
  * 4. for loop with Guards and Yields translated to a sequence of withFilter followed by map method call.
  */
object ForAndForEach {

  val stringArray = Array("ISRO","NASA","SPACEX")

  def main(args: Array[String]): Unit ={
    //forLoop()
    //foreachLoop()
    //forLoopTranslate()
    forLoopWithGuards()
  }

  def forLoop(): Unit ={
    // 1. Iterate collection/create new collection from the existing using for and foreach.

    for(x <- stringArray) println(x)
    for(x <- stringArray){
      val y = x.toLowerCase
      println(y)
    }

    // returning value from loop
    println("Return value from loop ----> for/yield")
    val newArray = for (x <- stringArray) yield x.toLowerCase
    newArray.foreach(println)

    // for loop counters
    for(a <- 0 until stringArray.length) println(s"$a is ${stringArray(a)}")

    // using zipWithIndex
    for((x,position) <- stringArray.zipWithIndex){
      println(s"$position is $x")
    }

    // looping over map
    val mapString = Map("India" -> "ISRO", "America" -> "NASA", "China" -> "CNSA")
    for((k,v) <- mapString){
      println(s"Country : $k Space Agency Name : $v")
    }
  }
  def foreachLoop(): Unit ={
    // Using foreach
    println("Using foreach ----> ")
    stringArray.foreach(println)
    stringArray.foreach( x => x.toLowerCase)
    stringArray.foreach{ x =>
      val length = x.length
      println(s"$x length is $length")
    }
  }
  def forLoopTranslate(): Unit ={
    //  scalac -Xprint:parse Main.scala
    //    [[syntax trees at end of                    parser]] // Main.scala
    //  package <empty> {
    //    class Main extends scala.AnyRef {
    //      def <init>() = {
    //        super.<init>();
    //          ()
    //        };
    //          1.to(10).foreach(((x) => println(x)))
    //        }
    //      }

    // 1. for loop - foreach method call
    println("for loop - foreach method call")
    for(x <- 1 to 10) println(x)
    1.to(10).foreach(((x) => println(x)))

    // 2. for loop with guards - withFilter followed by foreach
    println("for loop with guards - withFilter followed by foreach")
    for(x <- 1 to 10 if x % 2 == 0) println(x)
    1.to(10).withFilter(((x) => 1.$percent(2).$eq$eq(0))).foreach(((x) => println(x)))

    // 3. for loop with yields - map method call
    println("for loop with yields - map method call")
    for(x <- 1 to 10) yield x*2
    1.to(10).map(((x) => x.$times(2)))

    // 4. for loop with guards and yields - with filter followed by map method call
    println("for loop with guards and yields - with filter followed by map method call")
    for(x <- 1 to 10 if x%2 == 0) yield x*2
    1.to(10).withFilter(((x) => x.$percent(2).$eq$eq(0))).map(((x) => x.$times(2)))


  }

  def forLoopWithGuards(): Unit ={
    val companies = List("Google", "Amazon", "Facebbok", "MicroSoft", "IBM","IQVIA", "Amex")
    // single guard
    for(x <- companies if(x.length > 6)) println(x)

    // Multiple guards
    for(x <- companies if(x.length < 6); if(x.startsWith("I")) ) println(x)
    for{
      x <- companies
      if x.length < 6
      if x.startsWith("I")
    }println(x)
  }

}
