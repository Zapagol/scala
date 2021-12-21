package org.zap.scala.advanced

/**
  * Variance is the correlation of subtyping relationships of complex types and the subtyping
  * relationships of their component types
  *
  * 1. Covariant - class Covariant[+A]
  * 2. Contravariant - class Contravariant[-A]
  * 3. Invariant - class Invariant[A]
  */
object Variances extends App {

  /**
    * Covariance
    *
    * A type parameter A of a generic class can be made covariant by
    * using the annotation +A.
    *
    * For some class List[+A], making A covariant implies that for two types A and B
    * where A is a subtype of B, then List[A] is a subtype of List[B]. This allows
    * us to make very useful and intuitive subtyping relationships using generics.
    *
    */
  abstract class Animal {
    def name: String
  }
  case class Cat(name: String) extends Animal
  case class PersianCat(name: String) extends Animal
  case class Dog(name: String) extends Animal

  def printAnimalNames(animals: List[Animal]): Unit = {
    animals.foreach { animal =>
      println(animal.name)
    }
  }

  val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
  val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

  printAnimalNames(cats)
    // Whiskers
    // Tom
  printAnimalNames(dogs)
    // Fido
    // Rex

  def printAnimalNamesArray(animals: Array[Animal]): Unit = {
    animals.foreach { animal =>
      println(animal.name)
    }
  }

  val arrayCats: Array[Cat] = Array(Cat("Whiskers"), Cat("Tom"))
  val arrayDogs: Array[Dog] = Array(Dog("Fido"), Dog("Rex"))

  /**
    * Below piece of line won't compile as Array's are not covariant.
    */
  //printAnimalNamesArray(arrayCats)


  // ********** ContraVariance *************** //
  /**
    * A type parameter A of a generic class can be made contravariant by using the annotation -A.
    * This creates a subtyping relationship between the class and its type parameter that is
    * similar, but opposite to what we get with covariance. That is, for some class Writer[-A],
    * making A contravariant implies that for two types A and B where A is a subtype of B,
    * Writer[B] is a subtype of Writer[A]
    */

  abstract class Printer[-A] {
    def print(value: A): Unit
  }

  class AnimalPrinter extends Printer[Animal] {
    def print(animal: Animal): Unit =
      println("The animal's name is: " + animal.name)
  }

  class CatPrinter extends Printer[Cat] {
    def print(cat: Cat): Unit =
      println("The cat's name is: " + cat.name)
  }
  class PersianCatPrinter extends Printer[Cat]{
    def print(cat: Cat): Unit =
      println("The cat's name is: " + cat.name)
  }

  val myCat: Cat = Cat("Boots")

  def printMyCat(printer: Printer[Cat]): Unit = {
    printer.print(myCat)
  }

  val catPrinter: Printer[Cat] = new CatPrinter
  val animalPrinter: Printer[Animal] = new AnimalPrinter

  //Compilation error..
  //val persianCatPrinter: Printer[PersianCatPrinter] = new PersianCatPrinter

  printMyCat(catPrinter)
  printMyCat(animalPrinter)
  //printMyCat(persianCatPrinter)


  //****************** InVariant ***********************//

  /**
    *Generic classes in Scala are invariant by default. This means that they are neither covariant
    * nor contravariant. In the context of the following example, Container class is invariant.
    * A Container[Cat] is not a Container[Animal], nor is the reverse true.
    *
    * @param value
    * @tparam A
    */
  class Container[A](value: A) {
    private var _value: A = value
    def getValue: A = _value
    def setValue(value: A): Unit = {
      _value = value
    }
  }

  val catContainer: Container[Cat] = new Container(Cat("Felix"))
  // val animalContainer: Container[Animal] = catContainer -- compilation error


}
