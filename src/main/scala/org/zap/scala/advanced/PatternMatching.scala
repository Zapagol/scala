package org.zap.scala.advanced

object PatternMatching extends App {

  val numbers = List(1)

  val description = numbers match {
    case head :: Nil => println(s"The only element is $head")
    case _ =>
  }

  //Pattern matching with case class

  case class Employee(id: Int, name: String, lname: String)

  val edward = Employee(101, "Donald", "Trump")

  val greeting = edward match {
    case Employee(i, n, ln) => println(s"ID = $i and Name = $n")
    case Employee(i, _, _) => println(s"ID = $i")
    case Employee(_, n, _) => println(s"Name = $n")
    case _ => println("No Pattern Matching")
  }

  //Pattern matching with Normal Class
  class Person(val name: String, val age: Int)

  object Person {
    def unapply(person: Person): Option[(String, Int)] = Some((person.name, person.age))
    def unapply(age: Int): Option[String] = Some(if(age < 18) "minor" else "major")
  }

  val person = new Person("Rocky", 20)

  person match {
    case Person(n , a) => println(s"Hi, I am $n and I am $a year old")
  }

  person.age match {
    case Person(n) => println(s"My Voter Id Status is $n")
  }

  // Compilation error - Cann't resolve Symbol Person
  /*person match {
    case Person(n, a) => println(s"Hi my name is $n and I am $a year old.")
  }*/

}
