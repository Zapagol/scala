package org.zap.scala.advanced

/**
  * An extractor object is an object with an unapply method.
  * Whereas the apply method is like a constructor which takes arguments and creates an object,
  * the unapply takes an object and tries to give back the arguments.
  * This is most often used in pattern matching and partial functions.
  *
  * The return type of an unapply should be chosen as follows:
  *
  * - If it is just a test, return a Boolean. For instance case even().
  * - If it returns a single sub-value of type T, return an Option[T].
  * - If you want to return several sub-values T1,...,Tn, group them in an optional tuple Option[(T1,...,Tn)].
  */
object ExtractorObjects extends App{

  import scala.util.Random

  object CustomerID {

    def apply(name: String) = s"$name--${Random.nextLong}"

    def unapply(customerID: String): Option[String] = {
      val stringArray: Array[String] = customerID.split("--")
      if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
    }
  }

  // When we call CustomerID("Sukyoung"), this is shorthand syntax for calling CustomerID.apply("Sukyoung")
  val customer1ID = CustomerID("Sukyoung")  // Sukyoung--23098234908
  println(customer1ID)
  customer1ID match {
    // When we call case CustomerID(name) => println(name), we’re calling the unapply method
    // with CustomerID.unapply(customer1ID)
    case CustomerID(name) => println(name)  // prints Sukyoung
    case _ => println("Could not extract a CustomerID")
  }

  val customer2ID = CustomerID("Nico")
  val CustomerID(name) = customer2ID // This is equivalent to val name = CustomerID.unapply(customer2ID).get
  println(name)  // prints Nico


}
