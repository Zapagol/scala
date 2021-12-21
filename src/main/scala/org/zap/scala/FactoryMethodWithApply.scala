package org.zap.scala

object FactoryMethodWithApply extends App {

  // 1. using apply method

  trait Animal{
    def speak

  }

  object Animal{
    class Dog extends Animal{
      override def speak: Unit = {println("Dog spaek")}
    }
    class Cat extends Animal{
      override def speak: Unit = {println("Cat speak")}
    }

    //using factory method
    def apply(s: String): Animal = {
      s match {
        case "dog" => new Dog
        case _ => new Cat
      }
    }

    def getAnimal(s: String): Animal = {
      s match {
        case "dog" => new Dog
        case _ => new Cat
      }
    }
  }

  val dog = Animal("dog")
  val cat = Animal("cat")
  dog.speak
  cat.speak

  // 2. Other approach
  val dog1 = Animal.getAnimal("dog")
  val cat1 = Animal.getAnimal("cat")
  dog1.speak
  cat1.speak

}
