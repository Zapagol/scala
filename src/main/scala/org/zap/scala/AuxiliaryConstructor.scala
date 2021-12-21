package org.zap.scala

/**
  * The auxiliary constructor in Scala is used for constructor overloading and defined as a method
  * using this name.A scala class can contain zero or more auxiliary constructor.
  *
  * The auxiliary constructor must call either previously defined auxiliary constructor or primary
  * constructor in the first line of its body.
  *
  * Every auxiliary constructor invokes directly or indirectly primary constructor.
  *
  * We can define Auxiliary Constructors like methods by using “def” and “this” keywords. “this” is
  * the constructor name.
  */
object AuxiliaryConstructor {

  def main(args: Array[String]) {
    val auxiliaryConstructor1 = new AuxiliaryContructorCompany("Google", 1998, "Sundar Pichai")
    val auxiliaryConstructor2 = new AuxiliaryContructorCompany("Google", 1998)
    val auxiliaryConstructor3 = new AuxiliaryContructorCompany("Google")
    val auxiliaryConstructor4 = new AuxiliaryContructorCompany()

    val cc = CaseClass("John Smith", 30)

    //behind the scene
    val cc1 = CaseClass.apply("Virat Kohli", 34)

    val cc2 = CaseClass() // apply()
    val cc3 = CaseClass("John Miller") // apply(name: String)
  }
}

class AuxiliaryContructorCompany(name: String, founded: Int, ceo: String){

  // Auxiliary Constructor
  def this(name: String, founded: Int){
    this(name,founded,"") // invokes primary constructor
    println("Two argument auxiliary constructor")
  }
  def this(name: String){
    this(name,0,"")
    println("One argument auxiliary constructor")
  }
  def this(){
    this("",0,"")
    println("Zero argument auxiliary constructor")
  }

  println("primary constructor")
}

/**
  * Adding auxiliary constructor to a case class is different then the regular class.
  * This is because they’re not really constructors: they’re apply methods in the companion object
  * of the class.
  *
  * val cc = CaseClass("Sundar Pichai", 40)
  * Behind the scenes, Scala compiler convert it into
  * val cc = CaseClass.apply(""Sundar Pichai", 40)
  *
  * As a result, if you want to add new “constructors” to your case class, you write
  * new apply methods.
  *
  * @param name
  * @param age
  */
case class CaseClass(name: String, age: Int)
//companion object
object CaseClass {
  def apply() = new CaseClass(" ", 0)
  def apply(name: String) = new CaseClass(name, 0)
}

//val abc = CaseClass("Kiran", 10)