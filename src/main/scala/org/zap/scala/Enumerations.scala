package org.zap.scala

import scala.collection.mutable.ArrayBuffer

/**
  * Enumerations are a useful tool for creating small groups of constants, things like the days of the week,
  * months in a year, suits in a deck of cards, etc., situations where you have a group of related,
  * constant values.
  */
object Enumerations extends App {

  // This is how you create an enumeration for the days of a week:

  sealed trait DayOfWeek
  case object Sunday extends DayOfWeek
  case object Monday extends DayOfWeek
  case object Tuesday extends DayOfWeek
  case object Wednesday extends DayOfWeek
  case object Thursday extends DayOfWeek
  case object Friday extends DayOfWeek
  case object Saturday extends DayOfWeek

  // Similarly, this is how you create an enumeration for the suits in a deck of cards:

  sealed trait Suit
  case object Clubs extends Suit
  case object Spades extends Suit
  case object Diamonds extends Suit
  case object Hearts extends Suit

  // Pizza-related enumerations like this:

  sealed trait Topping
  case object Cheese extends Topping
  case object Pepperoni extends Topping
  case object Sausage extends Topping
  case object Mushrooms extends Topping
  case object Onions extends Topping

  sealed trait CrustSize
  case object SmallCrustSize extends CrustSize
  case object MediumCrustSize extends CrustSize
  case object LargeCrustSize extends CrustSize

  sealed trait CrustType
  case object RegularCrustType extends CrustType
  case object ThinCrustType extends CrustType
  case object ThickCrustType extends CrustType

  class Pizza (
                var crustSize: CrustSize = MediumCrustSize,
                var crustType: CrustType = RegularCrustType
              ) {

    // ArrayBuffer is a mutable sequence (list)
    val toppings = ArrayBuffer[Topping]()

    def addTopping(t: Topping): Unit = toppings += t
    def removeTopping(t: Topping): Unit = toppings -= t
    def removeAllToppings(): Unit = toppings.clear()

    override def toString(): String = {
      s"""
         |Crust Size: $crustSize
         |Crust Type: $crustType
         |Toppings:   $toppings
        """.stripMargin
    }
  }

  // a little "driver" app

  val p = new Pizza
  p.addTopping(Cheese)
  p.addTopping(Pepperoni)
  println(p)

}
