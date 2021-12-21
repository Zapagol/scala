package org.zap.scala

/**
  * Scala lets us control method visibility in a more granular and powerful way than Java.
  * In order from “most restrictive” to “most open,” Scala provides these scope options:
  *
  * Below are the ways where we can control method scope.
  *
  *  1. Object-private scope : When you mark object as object-private then that method is available
  *  to the current instance of the current object.Other instance of the same class can't access the method.
  *      You mark a method as object-private by placing the access modifier 'private[this]' before the
  *  method declaration
  *
  *  2. private : If we make method as private then that method available to
  *     a. Current class
  *     b. other instance of the current class
  *  And it is not accessible to subclasses.
  *
  *  3. protected : protected methods are available to sub-classes. The meaning of protected is slightly different
  *  in Scala than in Java. In Java,protected methods can be accessed by other classes in the same package,
  *  but this isn’t true in Scala.
  *       The method is available only to instances of the current class and subclasses of the current class.
  *
  *  4. Package-specific : Methods available to all members of current package.
  *       Mark the method as private to the current package with `private[package_name]` syantax
  *
  *  5. Public : If no access modifier is added to the method declaration, the method is public.
  */
object MethodScopes extends App{

  // 1. object-private

  class Calculator{
    private[this] def sum(a: Int, b: Int) =  a + b

    def displaySum1(): Unit ={
      println("Sum of 2 Integer is " + this.sum(10, 20))
    }

    // this won't compile. Symbol sum is inaccessible from this place
//    def displaySum2(other: Calculator): Unit ={
//      println("Sum of 2 Integer is " + other.sum(10, 20))
//    }
  }
  val calc = new Calculator
  calc.displaySum1()

  // 2. private

  class PrivateCalculator{
    private def sum(a: Int, b: Int) =  a + b

    def displaySum1(): Unit ={
      println("Sum of 2 Integer is " + this.sum(10, 20))
    }

    // this will compile now.
    def displaySum2(other: PrivateCalculator): Unit ={
      println("Sum of 2 Integer is " + other.sum(10, 20))
    }
  }
  val privateCalc = new PrivateCalculator
  privateCalc.displaySum1()
  privateCalc.displaySum2(new PrivateCalculator)

  class Animal {
    private def bread(){}
  }
  class Dog extends Animal{
    //this.bread -- this won't compile
  }

  // 3. Protected
  class Father {
    protected def creditCard(){println("Father credit card")}
  }
  class Son extends Father {
    def sonCreditcard(): Unit ={
      creditCard() // this will compile now
    }
  }
  val son = new Son
  son.sonCreditcard()

}
