package org.zap.scala.examples

import scala.collection.mutable.ListBuffer


object Test {
  case class Person(val name:String,val age:Int,val location:String)

  def main(args: Array[String]): Unit = {
    var personList = new ListBuffer[Person]()
    personList += Person("Rajesh", 21, "London")
    personList += Person("Suresh", 28, "California")
    personList += Person("Sam", 26, "Delhi")
    personList += Person("Rajesh", 21, "Gurgaon")
    personList += Person("Manish", 29, "Bengaluru")
    personList += Person("Manish", 33, "Bengaluru")
    //Todo write the logic here to remove duplicates
    val person = List(Person("Rajesh", 21, "London"),
      Person("Suresh", 28, "California"),
      Person("Rajesh", 21, "London")
    )
    println(distinct[Person](person))
  }

  def distinct[A](list:List[A]):List[A] =
    list.foldLeft(List[A]()) {
      case (acc, item) if acc.contains(item) => acc
      case (acc, item) => item::acc
    }

}
