package org.zap.scala.advanced

object GenericClasses extends App{

  //With Generic class MyStack[A]
  class MyStackWithGeneric[A]{
    private var elements: List[A] = Nil
    def push(x: A) { elements = x :: elements }
    def peek: A = elements.head
    def pop(): A = {
      val currentTop = peek
      elements = elements.tail
      currentTop
    }
  }

  //Without Generic Class
  class MyStackWithOutGeneric{
    private var elements: List[Int] = Nil
    def push(x: Int) { elements = x :: elements }
    def peek: Int = elements.head
    def pop(): Int = {
      val currentTop = peek
      elements = elements.tail
      currentTop
    }
  }

  val stackWithOutGeneric = new MyStackWithOutGeneric
  stackWithOutGeneric.push(23)
  stackWithOutGeneric.push(45)
  // stackWithOutGeneric.push("Hello") -- not possible

  val stringStack = new MyStackWithGeneric[String]
  val intStack = new MyStackWithGeneric[Int]

  stringStack.push("Java")
  stringStack.push("Scala")
  println(stringStack.pop())

  intStack.push(100)
  intStack.push(200)
  println(intStack.pop())

  //Instance stringStack and intStack can now only take Int or String.
  // If the type argument had subtype, those could be passed.

  class Bank
  class SavingAccount extends Bank
  class CurrentAccount extends Bank
  class DebitCard extends Bank
  class CreditCard extends Bank

  val bankStack = new MyStackWithGeneric[Bank]

  bankStack.push(new SavingAccount)
  bankStack.push(new DebitCard)
  bankStack.push(new Bank)

  println(bankStack.pop())

  val accountStack = new MyStackWithGeneric[SavingAccount]
  accountStack.push(new SavingAccount)
  //accountStack.push(new CurrentAccount) -- not possible
}
