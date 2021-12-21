package org.zap.scala

/**
  * use 'super' keyword to invoke method defined in super class.
  *
  * when a class inherits from multiple traits, and those traits have a common
  * method name, you can choose which trait to run the method using below syntax.
  *
  * syntax.
  *   super[traitName].methodName
  */
object CallingMethodOnSuperClass extends App{

  class Animal{
    def speak(): Unit ={
      println("Animal can't speak -->")
    }
  }

  class Dog extends Animal{
    override def speak(): Unit = {
      super.speak()
      println("Dog also can't speak -->")
    }
  }

  val dog = new Dog
  dog.speak()

  //controlling which trait we can call.

  trait Bank{
    def bank = println("I am super bank --> ")
  }
  trait SBI extends Bank{
    override def bank = println("I am Govt Bank --> ")
  }
  trait HDFC extends Bank {
    override def bank = println("I am Private Bank --> ")
  }

  class LocalBankTest1 extends Bank with SBI with HDFC{
    def print = super.bank // calls immediate super trait method.
    def usePrivateBank = super[HDFC].bank
    def useGovtBank = super[SBI].bank
    def useSuperBank = super[Bank].bank
  }

  val localBank = new LocalBankTest1
  localBank.print
  localBank.usePrivateBank
  localBank.useGovtBank
  localBank.useSuperBank

  class LocalBankTest2 extends SBI with HDFC{
    def print = super.bank // calls immediate super tarit method.
    def usePrivateBank = super[HDFC].bank
    def useGovtBank = super[SBI].bank
    //def useSuperBank = super[Bank].bank // error: won't compile
  }
}
