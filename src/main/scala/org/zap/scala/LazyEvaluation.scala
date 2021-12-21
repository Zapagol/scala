package org.zap.scala

/**
  * Scala uses strict evaluation by default, but allows lazy evaluation of value definitions with
  * the lazy val. Haskell is a functional programming language that uses lazy evaluation by default.
  *
  * The difference between them is, that a val is executed when it is defined whereas a lazy val is
  * executed when it is accessed first time.
  *
  * Few benefits of lazy evaluation in Scala
  *   1. Lazy evaluation can help to resolve circular dependencies.
  *   2. Increase Performance
  *
  * Scala supports two types of collections.
  *   1) Strict Collection: List, Map, Set etc
  *   2) Non-Strict Collections: Streams, View
  *
  */
object LazyEvaluation extends App {

  val govtBanks = List("SBI", "BOI", "Syndicate Bank")

  val bank = List("HDFC", "SBI", "ICICI")
  val flteredBank = bank.filter{
    println("without lazy val --> Finding goverment banks")
    bank => govtBanks.contains(bank)
  }

  lazy val flteredBankLazy = bank.filter{
    println("lazy val --> Finding goverment banks")
    bank => govtBanks.contains(bank)
  }

  // Circular dependency
  trait Foo {
    val foo: Foo
  }
  class Fee extends Foo {
    val foo = new Faa()
  }
  class Faa extends Foo {
    val foo = new Fee()
  }

  // println(new Fee().foo) - This could throw StackOverflowError

  trait Foo1 { val foo: Foo1 }
  class Fee1 extends Foo1 { lazy val foo = new Faa1() }
  class Faa1 extends Foo1 { lazy val foo = new Fee1() }

  println(new Fee1().foo)

  // with List - It's not lazy
  val intList = (1 to 20).filter{
    x => x % 2 != 0
  }.toList
  //intList: List[Int] = List(1, 3, 5, 7, 9, 11, 13, 15, 17, 19)

  // with Stream - Lazy
  /*
    Stream is eagerly evaluated at the head. Therefore, head of the stream has been printed but
    the tail is lazily computed. That’s why it has not been computing yet. It will be
    computed on demand.
   */
  val intStream = (1 to 20).filter{
    x => x % 2 != 0
  }.toStream
  //intStream: scala.collection.immutable.Stream[Int] = Stream(1, ?)

  (1 to 1000000000).filter(_ % 2 != 0).take(20).toList
//  java.lang.OutOfMemoryError: GC overhead limit exceeded
//    at java.lang.Integer.valueOf(Integer.java:832)
//  at scala.runtime.BoxesRunTime.boxToInteger(BoxesRunTime.java:65)
//  at scala.collection.immutable.Range.foreach(Range.scala:160)

  (1 to 1000000000).view.filter(_ % 2 != 0).take(20).toList
}
