package org.zap.scala

/**
  * We can control the superclass constructor that’s called by the primary
  * constructor in a subclass, but we can’t control the superclass constructor
  * that’s called by an auxiliary constructor in the subclass.
  *
  * Therefore, there’s no direct way to control which superclass constructor is called from
  * an auxiliary constructor in a subclass.
  *
  * In fact, because each auxiliary constructor must
  * call a previously defined constructor in the same class, all auxiliary constructors will
  * eventually call the same superclass constructor that’s called from the subclass’s primary
  * constructor.
  */
object CallingSuperClassConstructor extends App {

  class RBI1(name: String){
    //...
  }
  class HDFC(name: String) extends RBI1(name){
    println(name)
  }

  /*
    if the RBI class has multiple constructors, the primary constructor of the
    HDFC class can call any of those constructors.
   */
  class RBI2(name: String, code: Int){
    def this(name: String){
      this(name, 0)
    }
  }

  //calls the RBI2 1 arg constructor
  class ICICI(name: String) extends RBI2(name){
    println(name)
  }

}
