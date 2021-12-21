package org.zap.scala

/**
  * Constructors used for creating an instance (object) of a class.Scala can contain only
  * primary constructor or both primary and auxiliary constructor but can contain any number of
  * auxiliary constructors.
  *
  * Scala has two types of constructor.
  * 1. Primary constructor : Constructor which starts at Class definition and spans complete Class body.
  * We can define primary constructor with zero/one/more parameter. Primary constructor with zero parameter
  * called default primary contructor.
  *
  * 2. Auxiliary constructor
  */
object PrimaryConstructors {

  def main(args: Array[String]): Unit ={

    //Default Primary Constructor
    val company1 = new DefConstructorCompany // or new DefConstructorCompany()
    println("DefConstrucotrCompany name = " + company1.name)
    println(company1.display())

    //Primary Constructor
    val company2 = new PrimaryconstructorCompany("Google",1998, "Sundar Pichai")
    println(company2.dispaly())

    //Contructor Parameter with var fields
    val company3 = new PrimaryConstWithVarCompany("PayTm", 2010, "Vijay Shankar Sharma")
    //getter
    println(company3.ceo)
    //setter
    company3.ceo = "Vijay Sharma"
    println(company3.ceo)

    //Constructor Parameter with val fields
    val company4 = new PrimaryConstWithValCompany("FlikKart", 2017, "Sachin and Binny Bansali")
    //getter
    println(company4.ceo)

    //no setter
    //company4.ceo = "Sachin Bansali" -- Reassignment to val

    //Constructor Parameter without var and/or val
    val company5 = new PrimaryConstructorWithoutValandVarCompany("OLA", 2010, "Bhavish Agarwal")
    // company5.ceo -- error : value ceo is not member of  PrimaryConstructorWithoutValandVarCompany

    //Constructor parameter with private
    val company6 = new PrimaryConstructorWithPrivatePars("Facebook", 2004, "Mark Zukerberg")
    // println(company6.name) -- Not accessible
    // println(company6.founded) -- Not accessible
  }
}

/**
  * With default primary constructor.
  */
class DefConstructorCompany {

  // Body

  //Fields
  val name = "Google"
  val ceo = "Sundar Pichai"

  // Function
  def display(): Unit ={
    println(s"Who is CEO of $name? - $ceo")
  }
}

/**
  * With primary constructor.
  *
  * @param name
  * @param founded
  * @param ceo
  */
class PrimaryconstructorCompany(name: String, founded: Int, ceo: String){

  val stringValue = "Hello, Primary Constructor Class"

  def dispaly(): Unit ={
    println(s"Comapny $name founded in $founded and current CEO of company is $ceo")
  }
}

/**
  * If a constructor parameter is declared as a var, the value of the field can be changed. Scala
  * compiler will generate getter and setter method for class with var primary constructor parameters.
  *
  * To see generated getter and setter methods first use scalac class_name.scala to compile it
  * and then use javap class_name.class to generated java code.
  *
  * @param name
  * @param founded
  * @param ceo
  */
class PrimaryConstWithVarCompany(var name: String, var founded: Int, var ceo: String){

  //Generated Java code for PrimaryConstWithVarCompany

//  public class PrimaryConstWithVarCompany {
//    public java.lang.String name(); // Getter method
//    public void name_$eq(java.lang.String); // Setter method
//    public int founded(); // Getter method
//    public void founded_$eq(int); // Setter method
//    public java.lang.String ceo(); // Getter method
//    public void ceo_$eq(java.lang.String); // Setter method
//    public PrimaryConstWithVarCompany(java.lang.String, int, java.lang.String); // Constructor
//  }

}

/**
  * If a constructor field is defined as a val, the value of the field can’t be changed once it’s
  * been set; it’s immutable (like final in Java).
  *
  * To see generated getter methods first use scalac class_name.scala to compile it
  * and then use javap class_name.class to generated java code.
  *
  * @param name
  * @param founded
  * @param ceo
  */
class PrimaryConstWithValCompany(val name: String, val founded: Int, val ceo: String){

  // Generated Java Code for  PrimaryConstWithValCompany

//  public class PrimaryConstWithValCompany {
//    public java.lang.String name(); // Getter method
//    public int founded(); // Getter method
//    public java.lang.String ceo(); // Getter method
//    public PrimaryConstWithValCompany(java.lang.String, int, java.lang.String); // Constructor
//  }
}

/**
  *
  * if we don’t use “var” and “val” to define Primary Constructor’s parameters,
  * then Scala compiler does NOT generate setter and getter methods for them.
  *
  * @param name
  * @param founded
  * @param ceo
  */
class PrimaryConstructorWithoutValandVarCompany(name: String, founded: Int, ceo: String){

  // Generated Java Code for PrimaryConstructorWithoutValandVarCompany

  //  public class PrimaryConstructorWithoutValandVarCompany {
  //    public PrimaryConstructorWithoutValandVarCompany(java.lang.String, int, java.lang.String); // Constructor
  //  }
}

/**
  *
  * Primary constructor using val or var with private modifier then Scala compiler will not generate
  * getter and setter method for them.
  *
  * @param name
  * @param founded
  * @param ceo
  */
class PrimaryConstructorWithPrivateValVarCompany(name: String, founded: Int, ceo: String){

  // Generated Java Code for PrimaryConstructorWithPrivateValVarCompany

  //  public class PrimaryConstructorWithPrivateValVarCompany {
  //    public PrimaryConstructorWithPrivateValVarCompany(java.lang.String, int, java.lang.String); // Constructor
  //  }
}

/**
  * We can add the private keyword to a
  * val or var field. This keyword prevents getter and setter methods from being generated,
  * so the field can only be accessed from within members of the class
  *
  * @param name
  * @param founded
  * @param ceo
  */
class PrimaryConstructorWithPrivatePars(private var name: String, private val founded: Int, ceo: String)