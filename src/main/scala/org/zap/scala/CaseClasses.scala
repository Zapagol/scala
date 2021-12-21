package org.zap.scala

object CaseClasses extends App{

  /*
      equals, hashcode, toString, companion object
   */

  case class Company(name: String, founded: Int, founder: String)

  // 1. case class parameters are fields
  val company1 = new Company("Google", 1998, "Larey Page")
  println(company1.name) // Google

  // 2. Sensible toString
  // println(instance) = println(instance.toString) -- syntactic sugar
  println(company1) // Company(Google,1998,Larey Page)

  // 3. equals and hashcode implemented OOTB
  val company2 = new Company("Google", 1998, "Larey Page")
  println(company1 == company2) // true

  // 4. Case class have copy method
  val company3 = company2.copy(founder = "Larey Page and Sergey Brin")
  println(company3) // Company(Google,1998,Larey Page and Sergey Brin)

  // 5. Case class have companion object
  val company4 = Company

  // 6. Implements apply method.Create instance of the class without new kayword
  val company5 = Company("Facebook", 2004, "Mark Zukerberg")

  class Employee(name: String, id: Int){

  }

  object Employee {
    def apply(name: String, id: Int): String = {
      s"Hello $name"
    }
  }

  val employee = Employee("Harry", 423)
  val employee1 = Employee

  // 7. Case class extends Product trait and hence it inherits following method.
      /*
          1. def productArity: Int , returns the size of this product. In this case it corresponds to the
          number of arguments in the case class
          2. f productElement(n: Int): Any, returns the n-th element of this product, 0-based. In this case
          it corresponds to the n-th argument of the class.
          3. def productIterator: Iterator[Any], returns an iterator over all the elements of this product
          which, in the case class context, they are its arguments.
          4. def productPrefix: String, returns a string used in the toString method of the derived classes.
          In this case it’s the name of the class.
       */

  val parity = company3.productArity
  println(parity) // 3

  val founderOfFacebook = company5.productElement(2)
  println(founderOfFacebook) // Mark Zukerberg
  println(company5.productPrefix) // name of the class

  // 8. Case class extends Product and Product extends Equals so every case class also inherits canEqual method
  println(company5.canEqual(company2)) // true

  class Person(fname: String, lname: String){
    def canEqual(other: Any) = other.isInstanceOf[Person]
  }

  val person1 = new Person("Harry", "Kane")
  val person2 = new Person("Virat", "Kohli")

  println(person1.canEqual(person2)) // true

  class Student(name: String, id: Int){

  }

  val student = new Student("Elon Musk", 111)
  println(person1.canEqual(student)) // false

  // 9. Case classes are Serializable

  // 10 .case classes have extract patterns = CC can be used in PATTERN MATCHING

  /*
  when you create a case class, Scala generates a wealth of code
  for your class. To see the code that’s generated for you, first compile a simple case class,
  then disassemble it with javap.
   */

  /*
    1. Compile case class
      $ scalac Company.scala -- it generates two file one is Company.class and Company$.class file

    2. Disassemble it with javap
      $ javap Company
   */

  // Generated Boiler code

  /*
  //For javap Company

  public class Company implements scala.Product,scala.Serializable {
    public static scala.Option<scala.Tuple3<java.lang.String, java.lang.Object, java.lang.String>> unapply(Company);
    public static Company apply(java.lang.String, int, java.lang.String);
    public static scala.Function1<scala.Tuple3<java.lang.String, java.lang.Object, java.lang.String>, Company> tupled();
    public static scala.Function1<java.lang.String, scala.Function1<java.lang.Object, scala.Function1<java.lang.String, Company>>> curried();
    public java.lang.String name();
    public int founded();
    public java.lang.String founder();
    public Company copy(java.lang.String, int, java.lang.String);
    public java.lang.String copy$default$1();
    public int copy$default$2();
    public java.lang.String copy$default$3();
    public java.lang.String productPrefix();
    public int productArity();
    public java.lang.Object productElement(int);
    public scala.collection.Iterator<java.lang.Object> productIterator();
    public boolean canEqual(java.lang.Object);
    public int hashCode();
    public java.lang.String toString();
    public boolean equals(java.lang.Object);
    public Company(java.lang.String, int, java.lang.String);
  }*/

  /*
  // For javap Company$
  public final class Company$ extends scala.runtime.AbstractFunction3<java.lang.String, java.lang.Object, java.lang.String, Company> implements scala.Serializable {
  public static final Company$ MODULE$;
  public static {};
  public final java.lang.String toString();
  public Company apply(java.lang.String, int, java.lang.String);
  public scala.Option<scala.Tuple3<java.lang.String, java.lang.Object, java.lang.String>> unapply(Company);
  public java.lang.Object apply(java.lang.Object, java.lang.Object, java.lang.Object);
}
   */


}

