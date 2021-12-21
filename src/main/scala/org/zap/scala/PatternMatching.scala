package org.zap.scala

import scala.util.Random

object PatternMatching {

  trait Bank
  case class SavingAccount(accId: Long) extends Bank
  case class CurrentAccount(accId: Long) extends Bank
  case class JointAccunt(accId: Long) extends Bank
  case class Person(age: Int) extends Bank

  def main(args: Array[String]): Unit ={
    println(basicPatternMatching("Google"))
    println(basicPatternMatching("Facebook"))

    println(caseClassPM(SavingAccount(3451778L)))
    println(caseClassPM(JointAccunt(9876287L)))
    println(caseClassPM(Person(25)))

    println(patternGuard(SavingAccount(3451778L)))
    println(patternGuard(SavingAccount(3458L)))

  }

  def basicPatternMatching(companyName: String): String ={
    val company = companyName match {
      case "Google" => s"$companyName founded in 1998 and founder is Larry Page and Sergy Brin"
      case "Amazon" => s"$companyName founded in 1994 and founder is Jeff Bezos"
      case "Microsoft" => s"$companyName founded in 1975 and founder is Bill Gates and Paul Allen"
      case _ => s"Sorry, We couldn't find details of company $companyName"
    }
    company
  }

  def caseClassPM(bank: Bank): String ={
    val random = new Random
    val minimum = 500
    val max = 100000
    val balance = random.nextInt(max - minimum) + minimum

    val details = bank match {
      case SavingAccount(id) => s"Balance for Saving Account Id $id is $balance"
      case CurrentAccount(id) => s"Balance for Current Account Id $id is $balance"
      case JointAccunt(id) => s"Balance for Joint Account Id $id is $balance"
      case _ => s"Sorry, your account doesn't exist. Please contact bank for more details"
    }
    details
  }

  def patternGuard(bank: Bank): String ={
    val random = new Random
    val minimum = 500
    val max = 100000
    val balance = random.nextInt(max - minimum) + minimum

    val details = bank match {
      case SavingAccount(id) if  id.toString.length < 5 => s"Sorry, It's not a valid account number"
      case SavingAccount(id) => s"Balance for Saving Account Id $id is $balance"
      case CurrentAccount(id) => s"Balance for Current Account Id $id is $balance"
      case JointAccunt(id) => s"Balance for Joint Account Id $id is $balance"
      case _ => s"Sorry, your account doesn't exist. Please contact bank for more details"
    }
    details
  }
}
