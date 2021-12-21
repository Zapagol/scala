package org.zap.scala

/**
  * Mixins are traits which are used to compose a class.
  *
  * Class D has a superclass B and a mixin C. Classes can only have one
  * superclass but many mixins (using the keywords extends and with respectively).
  * The mixins and the superclass may have the same supertype.
  */
object ClassCompositionWithMixins extends App {

  abstract class A {
    val message: String
  }
  class B extends A {
    val message = "I'm an instance of class B"
  }
  trait C extends A {
    def loudMessage = message.toUpperCase()
  }
  class D extends B with C

  // class E extends C with B -- won't work

  val d = new D
  println(d.message)  // I'm an instance of class B
  println(d.loudMessage)  // I'M AN INSTANCE OF CLASS B


  //Example

  abstract class AbsIterator {
    type T
    def hasNext: Boolean
    def next(): T
  }

  class StringIterator(s: String) extends AbsIterator {
    type T = Char
    private var i = 0
    def hasNext = i < s.length
    def next() = {
      val ch = s charAt i
      i += 1
      ch
    }
  }

  //This trait implements foreach by continually calling the provided function f: T => Unit
  // on the next element (next()) as long as there are further elements (while (hasNext)).
  trait RichIterator extends AbsIterator {
    def foreach(f: T => Unit): Unit = while (hasNext) f(next())
  }

  // Combine the functionality of StringIterator and RichIterator into a single class.
  // With single inheritance we would not be able to achieve this level of flexibility.
  class RichStringIter extends StringIterator("Scala") with RichIterator
  val richStringIter = new RichStringIter
  richStringIter.foreach(println)

  // trait can be extended while creating object also
  trait Text { def txt()}
  abstract class LowerCase { def lowerCase ()}
  class TextApp(message: String) extends LowerCase {
    def lowerCase(): Unit = println(message.toLowerCase)
    def txt() = println(message)
  }

  val textApp = new TextApp("Hello, Welcome to Scala") with Text
  textApp.lowerCase()
  textApp.txt()
}
