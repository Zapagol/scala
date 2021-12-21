package org.zap.scala

/**
  * Traits, Abstract and classes can be marked sealed which means all subtypes must be declared in the same file.
  * This assures that all subtypes are known.
  *
  */
object SealedClasses {

  sealed abstract class Furniture
  case class Couch() extends Furniture
  case class Chair() extends Furniture

  sealed trait Device
  case class Phone(model: String) extends Device {
    def screenOff = "Turning screen off"
  }
  case class Computer(model: String) extends Device {
    def screenSaverOn = "Turning screen saver on..."
  }

  val option = Some("")

}
