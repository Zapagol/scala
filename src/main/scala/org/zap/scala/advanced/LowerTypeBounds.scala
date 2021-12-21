package org.zap.scala.advanced

/**
  * Lower type bounds declare a type to be a supertype of another type.
  * The term B >: A expresses that the type parameter B or the abstract type
  * B refer to a supertype of type A. In most cases, A will be the type
  * parameter of the class and B will be the type parameter of a method.
  */
object LowerTypeBounds extends App {

  trait Thing
  trait Vehicle extends Thing
  class Car extends Vehicle
  class Jeep extends Car
  class Coupe extends Car
  class Motorcycle extends Vehicle
  class Vegetable

  // In this Parking we would park any superType of Jeep
  class Parking[A >: Jeep]

  val carParking = new Parking[Car]
  val vehicleParking = new Parking[Vehicle]
  val thingParking = new Parking[Thing]

  // this won't compile because MotorCycle is not supertype of Jeep
  // Error:(26, 7) type arguments [org.zap.scala.advanced.LowerTypeBounds.Motorcycle] do not
  // conform to class Parking's type parameter bounds [A >: org.zap.scala.advanced.LowerTypeBounds.Jeep]
  //  val motorcycle = new Parking[Motorcycle]
    //val motorcycle = new Parking[Motorcycle]

  class Animal
  class Dog extends Animal
  class Puppy extends Dog

  class AnimalUpperBound{
    def display [T <: Dog](t: T){
      println(t)
    }
  }

  val animal = new Animal
  val dog = new Dog
  val puppy = new Puppy

  val animalUB = new AnimalUpperBound

  //animalCarer.display(animal)
  animalUB.display(dog)
  animalUB.display(puppy)

  class AnimalLowerBound{
    def display [T >: Puppy](t: T){
      println(t)
    }
  }

  val animalLB = new AnimalLowerBound

  animalLB.display(animal)

  //Here Dog is not a subtype of Puppy, but still this program works fine because Dog is a subtype of Animal
  animalLB.display(dog)
  animalLB.display(puppy)




}
