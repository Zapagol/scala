package org.zap.scala

import java.util.Random

/**
  * An Option is a wrapper for a value that might be present or not.
  * Signature:
  *
  *   sealed abstract class Option[+A]
  *   case class Some[+A](x: A) extends Option[A]
  *   case class None extends Option[Nothing]
  */
object Options extends App {

  val option1: Option[Int] = Some(10)
  val option2: Option[Int] = None

  option1.isDefined

  println(option1)

  // Unsafe API's
  def unsafeFunction(): String = null
  //val result1 = Some(unsafeFunction()) -- Wrong
  val result2 = Option(unsafeFunction()) // Some or None
  println(result2)

  // chained methods
  def backupMethods(): String = "Hello, Welcome to Scala"

  val result3 = Option(unsafeFunction()).orElse(Option(backupMethods()))
  println(result3)

  // Design unsafe API's
  def betterUnsafeFunction(): Option[String] = None
  def betterBackuoFunction(): Option[String] = Some("Hello, Welcome to Scala")

  val betterResult = betterUnsafeFunction() orElse betterBackuoFunction()
  println(betterResult)

  // functions on Options
  println(option1.isEmpty)
  println(option1.get) // UnSafe

  // map, flatMap, filter
  println(option1.map(_ * 2))
  println(option1.filter(_ > 20))
  println(option1.flatMap(x => Option(x + 20)))


  val config: Map[String, String] = Map(
    "host" -> "120.21.56.9",
    "port" -> "8080"
  )

  class Connection {
    def connect = "conncted"
  }
  object Connection{
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if(random.nextBoolean()) Some(new Connection)
      else None
    }
  }

  //try to establish connection - if so print connect
  val host = config.get("host")
  val port = config.get("port")

  /*
      if(h != null)
        if(p != null)
          return Connection.apply(h, p)
      return null
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))

  /*
      if(c != null)
        return c.connect
      return null
   */
  val connectionStatus = connection.map(c => c.connect)

  /*
      if(connectionStatus == null) println print(None) else print(Some(connectionStatus.get))
   */
  println(connectionStatus)

  /*
      if(status != null)
        print(status)
   */
  connectionStatus.foreach(println)

  // chained calls
  config.get("host")
    .flatMap(h => config.get("port")
    .flatMap(p => Connection(h, p))
    .map(c => c.connect))
    .foreach(println)

  // for- comprehensions
  val forConnectionStatus = for{
    port <- config.get("host")
    host <- config.get("port")
    connection <- Connection(port, host)
  } yield connection.connect
  forConnectionStatus.foreach(println)

  // Option.isDefined - Returns true if the option is an instance of $some, false otherwise.
    // example1
    case class customer(id: Int, name: Option[String])
    val customer1 = customer(100, None)
  val customer2 = customer(200, Some("John"))

    // It throws java.util.NoSuchElementException: None.get
//    val unsafeNames = Seq(customer1, customer2)
//          .map(_.name.get)

    val names = Seq(customer1, customer2)
      .filter(_.name.isDefined)
      .map(_.name.get)

    names.foreach(print)


}
