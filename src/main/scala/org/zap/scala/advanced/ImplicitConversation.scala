package org.zap.scala.advanced

import org.apache.spark.sql.{Dataset, SparkSession}

import scala.util.Try

/**
  * An implicit conversion from type S to type T is defined by an implicit value which has function
  * type S => T, or by an implicit method convertible to a value of that type.
  *
  * Implicit definitions are those that the compiler is allowed to insert into a program in order
  * to fix any of its type errors.
  *
  * Marking Rule : Only definitions marked implicit are available. The implicit keyword is used to mark
  * which declarations the compiler may use as implicits. You can use it to mark any variable, function,
  * or object definition.
  */
object ImplicitConversation extends App{

  // Implicit conversion to an expected type
  implicit def doubleToInt(x: Double): Int = x.toInt
  implicit def companyToInt(company: Company): Int = company.numberOfEmployees
  implicit def stringEnhancement(s: String) = new EnhancedString(s)
  implicit def dataSetImprovement[T](dataset: Dataset[T]): DatasetEnhancement[T] = new DatasetEnhancement(dataset)

  case class Company(name: String, founded: Int, numberOfEmployees: Int, revenue: Int)

  def display(company: Company): Unit ={
    println(s"Company Name : ${company.name}" + "\n" +
            s"Founded : ${company.founded}" + "\n" +
            s"Number of Employees : ${company.numberOfEmployees}" + "\n" +
            s"Revenue : ${company.revenue} billion")
    println("--------------------------------------------------------------------------------")
  }

  val company = Company("Microsoft", 1975, 144500, 232.900)

  display(company)
  display(Company("Microsoft", 1975, company, 125.8))

  //String Enhancement
  class EnhancedString(val s: String) {
    def legthWithoutSpace = s.trim.length
    def toList1 = s.toCharArray.toList
    def removeSpecialChars = s.replaceAll("[^a-zA-Z]", "")
    def stringToMap = {
      val array = s.split(" ")
      Map(array(0) -> array(1))
    }
  }

  println("Enhanced String Functions ---> ")
  println("String length with space : " + "    Hello, Welcome to Scala   ".length)
  println("String length without space : " + "    Hello, Welcome to Scala   ".legthWithoutSpace)
  println("Removed Special chars : " + "@Google#*".removeSpecialChars)

  val string2Map = "Google 1998".stringToMap
  println(string2Map)


  //Datset Enhancement

  class DatasetEnhancement[T](dataset: Dataset[T]){
    def isEmpty: Boolean = Try(dataset.first()).isFailure
    def zipWithIndex = dataset.rdd.zipWithIndex()
  }

  val spark = SparkSession
    .builder()
    .master("local")
    .getOrCreate()

  import spark.implicits._
  val stringDataset = Seq("Google", "Amazon", "Microsoft").toDS
  println(stringDataset.isEmpty) // false
  println(stringDataset.show(false))
  println(stringDataset.zipWithIndex.toDS().show(false))


  val map = Map(1 -> "One", 2 -> "Two")

  // compiler will get confuse
  case class Person(name: String) {
    def greet = s"Hi, my name is $name!"
  }

  implicit def fromStringToPerson(str: String): Person = Person(str)

  println("Peter".greet) // println(fromStringToPerson("Peter").greet)

  //  class A {
  //    def greet: Int = 2
  //  }
  //  implicit def fromStringToA(str: String): A = new A


}
