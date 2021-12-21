package org.zap.scala.advanced

/**
  * An implicit class is a class marked with the implicit keyword. This keyword makes the class’s
  * primary constructor available for implicit conversions when the class is in scope.
  *
  * Restrictions:
  *
  * 1. They must be defined inside of another trait/class/object
  * 2. They may only take one non-implicit argument in their constructor.
  * 3. There may not be any method, member or object in scope with the same name as the implicit class.
  */
object ImplicitClasses extends App{
  implicit class ArrowAssocExtended[A](private val self: A) extends AnyVal {
    def >>>> [B](y: B): Tuple2[A, B] = {
      println(" self value = "+self)
      println(" y value = "+y)
      Tuple2(self, y)
    }
  }

  implicit class StringEnhancer[A](val self: A) extends AnyVal {
    def stringToMap[B](y: B): Map[A,B] = {
      Map(self -> y)
    }
    def stringToTuple[B](y: B): (A, B) = {
      (self, y)
    }
  }

  val map1 = Map(1 >>>> "One", 2 >>>> "Two")
  map1.foreach(println)
  val map2 = Map(1.>>>>("One"), 2 >>>> "Two")

  val stringToMap = "Google".stringToMap(1998)
  println(stringToMap)

  val stringToTuple = "Google".stringToTuple(1998)
  println(stringToTuple)

  case class Company(name: String, founder: String, founded: Int)
  val company1 = Company("Google", "Larrey Page and Sergey brin", 1998)

  val companyMap = company1.name stringToMap company1
  println(companyMap)

  val list = List((1,"One"),(2, "Two"))

  print(list.toMap)

  val abc = "123"
  println(abc.length)
  //println(abc.substring(3, 4))

  if(abc.length > 3){
    if(abc.substring(3, 4).equals("4")) {
      println("condition")
    }
  }else println("not condition ")

  abc

}
