package org.zap.scala

import akka.actor.Actor

/**
  * A case object is like an object, but just like a case class has more features than a regular class, a case
  * object has more features than a regular object. Its features include:
  *
  *  - It’s serializable
  *  - It has a default hashCode implementation
  *  - It has an improved toString implementation
  *  - It has support for pattern matching
  *
  * Because of these features, case objects are primarily used in two places (instead of regular objects):
  *
  * 1. When creating enumerations
  * 2. When creating containers for “messages” that you want to pass between other objects (such as with the
  * Akka actors library)
  *
  * Difference between case class and case object
  *   - A case class can take arguments, so each instance of that case class can be different based on the values
  *   of it's arguments.
  *   - A case object on the other hand does not take args in the constructor, so there can only be one instance of it
  */
object CaseObject {

  // Creating Enumeration with case objects

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

  case class Pizza (
                     crustSize: CrustSize,
                     crustType: CrustType,
                     toppings: Seq[Topping]
                   )


  // Using case objects as messages

  // Notice that StartSpeakingMessage is defined as a case class rather than a case object. This is because a
  // case object can’t have any constructor parameters.
  case class StartSpeakingMessage(textToSpeak: String)
  case object StopSpeakingMessage
  case object PauseSpeakingMessage
  case object ResumeSpeakingMessage

  class Speak extends Actor {
    def receive: PartialFunction[Any, Unit] = {
      case StartSpeakingMessage(textToSpeak) =>
      // code to speak the text
      case StopSpeakingMessage =>
      // code to stop speaking
      case PauseSpeakingMessage =>
      // code to pause speaking
      case ResumeSpeakingMessage =>
      // code to resume speaking
    }
  }

}
