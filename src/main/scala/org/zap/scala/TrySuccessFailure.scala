package org.zap.scala

import java.io.{FileNotFoundException, InputStream}
import java.net.{MalformedURLException, URL}

import scala.io.Source
import scala.util.{Failure, Success, Try}

/**
  * The `Try` type represents a computation that may either result in an exception, or return a successfully
  * computed value.
  *
  * Instances of Try[T], are either an instance of scala.util.Success[T] or scala.util.Failure[T].
  * An Important property of Try is it's ability to pipeline, or chain, operations, catching exceptions
  * along the way.
  *
  * Defination:
  *   sealed abstract class Try[+A]
  *   case class Failure[+A](t: Throwable) extends Try[A]
  *   case class Success[+A](value: A) extends Try[A]
  */
object TrySuccessFailure extends App{

  example1(30, 40, "+")
  example1(30, 0, "/")
  example2("/tmp/Try")

  //Pattern Matching
  def example1(a: Int, b: Int, indicator: String): Unit ={
    // Example 1
    Try (calculator(a, b, indicator)) match {
      case Success(s) => println(s)
      case Failure(e) => println(e.printStackTrace())
    }
  }

  def example2(filename: String): Unit ={
    readTextFile(filename) match {
      case Success(lines) => lines.foreach(println)
      case Failure(e) => println(e.printStackTrace())
    }
  }


  def calculator(a: Int, b: Int, indicator: String): Int ={
    indicator match {
      case "+" => a + b
      case "*" => a * b
      case "/" => a / b
     }
  }

  def readTextFile(filename: String): Try[List[String]] = {
    Try(Source.fromFile(filename).getLines.toList)
  }

  def unsafeMethod(): String = throw new RuntimeException("Exception occurred")
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)
  println(potentialFailure.isSuccess)

  // orElse
  def backupMethod(): String = "Hello, you are not welcome to Scala"
  val fallBackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallBackTry)

  // Design API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackUpMethod(): Try[String] = Success("Hello, you are now welcome to Scala")

  val betterFallBack = betterUnsafeMethod() orElse betterBackUpMethod()
  println(betterFallBack)

  def parseURL(url: String): Try[URL] = Try(new URL(url))

  println(parseURL("http://google.com").isSuccess)
  println(parseURL("google").isSuccess)

  //get Value
  println(parseURL("http://google.com").get)

  //Get default URL - for Failure cases
  println(parseURL("google") getOrElse new URL("http://google.com"))

  /**
    * Chaining Operations
    */
  //Mapping and Flat Mapping
  println(parseURL("http://google.com").map(_.getProtocol))
  println(parseURL("google").map(_.getProtocol))

  //Multiple map operations - nested Try Structure
  def inputStreamURLMap(url: String): Try[Try[Try[InputStream]]] =
    parseURL(url).map{ u => Try(u.openConnection())
        .map(conn => Try(conn.getInputStream))
    }

  /**
    * The flatMap method on a Try[A] expects to be passed a function that receives an A and returns a Try[B].
    * If our Try[A] instance is already a Failure[A], that failure is returned as a Failure[B], simply passing
    * along the wrapped exception along the chain. If our Try[A] is a Success[A], flatMap unpacks the A value
    * in it and maps it to a Try[B] by passing this value to the mapping function.
    *
    * @param url
    * @return
    */
  def inputStreamURLFlatMap(url: String): Try[InputStream] =
    parseURL(url).flatMap{ u => Try(u.openConnection())
      .flatMap(conn => Try(conn.getInputStream))
    }

  // filter and foreach operations
  def parseHttpURL(url: String): Try[URL] = parseURL(url).filter(_.getProtocol == "http")

  println(parseHttpURL("http://google.com")) //Success(http://google.com)
  println(parseHttpURL("https://google.com")) //Failure(java.util.NoSuchElementException: Predicate does not hold for https://google.com)

  //For comprehensions
  def getURLContent(url: String): Try[Iterator[String]] =
    for {
      url <- parseURL(url)
      connection <- Try(url.openConnection())
      is <- Try(connection.getInputStream)
      source = Source.fromInputStream(is)
    } yield source.getLines()

  //Recovering from a Failure
  val content = getURLContent("garbage") recover {
    case e: FileNotFoundException => Iterator("Requested page does not exist")
    case e: MalformedURLException => Iterator("Please make sure to enter a valid URL")
    case _ => Iterator("An unexpected error has occurred. We are so sorry!")
  }

}
