package org.zap.scala

/**
  * Traits are used to share interfaces and fields between classes.
  * They are similar to Java 8’s interfaces. Classes and objects can extend traits but traits cannot
  * be instantiated and therefore have no parameters.
  */
object Traits extends App {

  // 1. Using trait as Java interface

  trait Animal {
    def speak() // with no arguments
    def walk(direction: String) // with arguments
  }

  // extending 1 trait
  class Dog extends Animal{
    override def speak: Unit = {println("Dog speak -->")}
    override def walk(direction: String): Unit = println(s"I can walk in $direction direction" )
  }

  class PetAnimals{
    def eat = print("Pet Animals can eat at home")
  }

  //extending class and traits
  class Cat extends PetAnimals with Animal{
    override def speak: Unit = {println("Cat speak -->")}
    override def walk(direction: String): Unit = println(s"I can walk in $direction direction" )
  }
  //error : wont't compile. We should use extend for the class and with for the subsequent traits.
  /*class Cat1 extends Animal with PetAnimals{
    override def speak: Unit = {println("Cat speak -->")}
    override def walk(direction: String): Unit = println(s"I can walk in $direction direction" )
  }*/

  //If a class not implements all the abstract methods defined in that trait, it must be declared abstract.
  abstract class Tiger extends Animal{
    override def speak: Unit = println("Tiger Speak --> ")
  }
  //error : won't compile.
  /*class Tiger extends Animal{
    override def speak: Unit = println("Tiger Speak --> ")
  }*/

  /*
    fields of the trait can be declared val or var.Don't need to override a var fields
    but we need to override a val fields.
   */
  trait Parents{
    var numberOfDebitCard: Int // abstract
    var numberOfCreditCards = 3 // concrete
  }
  class Son extends Parents{
    var numberOfDebitCard: Int = 3
    numberOfDebitCard = 2
  }

  /*
    “Any concrete class that mixes in the trait must ensure that its type conforms to the trait’s
    self type“
   */
  class Addition{
    def +(a: Int, b: Int) = a + b
  }

   trait Calculator{
    this: Addition =>
     def -(a: Int, b: Int): Int
     def *(a: Int, b: Int): Int
  }

  class SimpleCalculator1 extends Addition with Calculator{
    override def *(a: Int, b: Int) : Int = a * b
    override def -(a: Int, b: Int) : Int = a - b
  }
  class Divide{
    def /(a: Int, b: Int): Double = a / b
  }

  //error : won't compile. illegal inheritance.
  /*class SimpleCalculator2 extends Divide with Calculator{
    override def *(a: Int, b: Int) : Int = a * b
    override def -(a: Int, b: Int) : Int = a - b
  }*/

  /*
    Structural Type : Ensuring a Trait Can Only Be Added to a Type That Has a Specific Method.
   */
  //Bank trait requires that any classes that attempt to mix it in must have an method: rbiPermission
  //And it should accept String argument and return a Boolean Value.
  trait Bank{
    this: { def rbiPermission(): Boolean } =>
    def print() = println("Hello, Welcome")
  }

  //It compile successfully.
  class HDFCBank() extends Bank {
    def rbiPermission(): Boolean ={
      true
    }
    def openMainBranch(location: String): Unit ={
      if(rbiPermission()) println(s"Main Branch opened successfully in $location")
    }
  }

  //error : it won't compile. Illegal inheritance.Self Type trait doesn't confirm to
  // { def rbiPermission(): Boolean } =>
  /*class VijayaBank() extends Bank {
    def openMainBranch(location: String): Unit ={
       println(s"Main Branch opened successfully in $location")
    }
  }*/

  /*
    Adding trait to an object instance
   */

  trait BankRules{
    println("I am in trait called BankRules")
    def homeLoanInterest(bankName: String): Unit = println(s"$bankName HomeLoan Interest is 8.5%")
  }

  class SBI extends BankRules{}

  val sbi = new SBI
  sbi.homeLoanInterest("SBI")

  class HDFC{}

  val hdfc = new HDFCBank with BankRules
  hdfc.homeLoanInterest("HDFC")

  trait EntityDescription[T] extends Serializable {
    val tableName: String
    val primaryKey: List[String]
    val partitions: List[String]
  }

  case class Product(product_name: String, product_id: Int, customer_id: Int) extends EntityDescription[Product]{
    override val tableName = "product"
    override val primaryKey: List[String] = List("product_id")
    override val partitions: List[String] = List("default_name")
  }
}
