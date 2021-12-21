package org.zap.scala.advanced

import org.apache.spark.sql.SparkSession
import org.zap.scala.SparkSessionLocal

/**
  *
  * When we talk about implicits in Scala, we're talking about 2 closely related language features
  *   1. implicit parameters
  *   2. implicit conversation
  *
  * Both of them involve the compiler implicitly(i.e invisibly) resolving certain type errors using
  * extra informations supplied in scope but not at the site of type error
  *
  * For implicit parameters, this is the error that which occurs when method call does not supply all
  * the required parameters.
  * For implicit conversations, it's the error that occurs when a supplied type does not match the
  * expected type
  *
  *
  * A method can have an implicit parameter list, marked by the implicit keyword at the start of the
  * parameter list. If the parameters in that parameter list are not passed as usual, Scala will look
  * if it can get an implicit value of the correct type, and if it can, pass it automatically.
  *
  * If an implicit field of the same type is in scope, it pulls it right in ... with the limit that it can
  * only deal with one implicit field of the matching type at one time.
  */
object ImplicitParameters extends App with SparkSessionLocal{

  implicit val firstInteger = 10
  /**
    *
    * `Implicits in Scala refers to either a value that can be passed “automatically”, so to speak, or`
    * `a conversion from one type to another that is made automatically`.
    *
    * ambiguous implicit values:
    * both value firstInteger in object ImplicitParameters of type => Int
    * and value intValue in object ImplicitParameters of type => Int
    * match expected type Int
    * println(simpleCalculator("add", 4))
    */
  //implicit val intValue = 25

  def simpleCalculator(indicator: String, a: Int)(implicit b: Int): Double = {
    indicator match {
      case "add" => a + b
      case "minus" => a - b
      case "multiply" => a * b
      case "divide" => if( b == 0) 0 else a / b
    }
  }

  println(simpleCalculator("add", 4))
  println(simpleCalculator("multiply", 10))

  def datasetExample()(implicit spark: SparkSession): Unit ={
    import spark.implicits._
    val mapString = List("India" -> "Delhi", "France" -> "Paris").toDS()
    println(mapString.show(false))
  }

  datasetExample()

}
