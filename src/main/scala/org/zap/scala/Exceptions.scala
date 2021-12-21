package org.zap.scala

import java.io.{FileNotFoundException, FileReader, IOException}

object Exceptions extends App{

  @throws(classOf[ArithmeticException])
  def createConnection1 {
    // exception throwing code here ...
    throw new ArithmeticException()
  }

  //Equivalent code in JAVA
  /*public void play() throws FooException {
    // code here ...
  }*/

  /**
    * try/catch/finally
    */

  try {
    new FileReader("input.txt")
  } catch {
    case ex: FileNotFoundException => println("Missing file exception")
    case ex: IOException => println("IO Exception")
    case _: Throwable =>
  }finally {
    //Final code here
  }

}
