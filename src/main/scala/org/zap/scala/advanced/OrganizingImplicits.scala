package org.zap.scala.advanced

object OrganizingImplicits extends App {

  implicit def reverseOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _)
  println(List(2,10,5,8,21).sorted)


  case class Person(name: String, age: Int)

  val persons = List(
    Person("John", 22),
    Person("Bob", 17),
    Person("Peter", 42),
    Person("Mark", 65)
  )

  object Person{
    implicit def nameOrdering: Ordering[Person] = Ordering.fromLessThan((a, b) => a.name.compareTo(b.name) < 0 )
  }

  implicit def ageOrdering: Ordering[Person] = Ordering.fromLessThan((a, b) => a.age < b.age )
  println(persons.sorted)

  /*
    Implicit scope
    - normal scope = LOCAL SCOPE
    - imported scope
    - companions of all types involved in the method signature
      - List
      - Ordering
      - all the types involved = A or any supertype
   */
  // def sorted[B >: A](implicit ord: Ordering[B]): List[B]

  object AlphabeticNameOrdering {
    implicit val alphabeticOrdering: Ordering[Person] = Ordering.fromLessThan((a, b) => a.name.compareTo(b.name) < 0)
  }

  object AgeOrdering {
    implicit val ageOrdering: Ordering[Person] = Ordering.fromLessThan((a, b) => a.age < b.age)
  }

  println(persons.sorted)

  /*
    Exercise.
    - totalPrice = most used (50%)
    - by unit count = 25%
    - by unit price = 25%
   */
  case class Purchase(nUnits: Int, unitPrice: Double)
  object Purchase {
    implicit val totalPriceOrdering: Ordering[Purchase] = Ordering.fromLessThan((a,b) => a.nUnits * a.unitPrice < b.nUnits * b.unitPrice)
  }

  object UnitCountOrdering {
    implicit val unitCountOrdering: Ordering[Purchase] = Ordering.fromLessThan(_.nUnits < _.nUnits)
  }

  object UnitPriceOrdering {
    implicit val unitPriceOrdering: Ordering[Purchase] = Ordering.fromLessThan(_.unitPrice < _.unitPrice)
  }
}
