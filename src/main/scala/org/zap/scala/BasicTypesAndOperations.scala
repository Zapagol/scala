package org.zap.scala

object BasicTypesAndOperations {

  def main(args: Array[String]): Unit ={
    stringInterpolation()
  }

  def scalaLiterals(): Unit ={
    //Integer Literals
        // 1.HexaDecimal
        // 2. Decimal

    //HexaDecimal
    val x = 0x10
    println(x)

    val y = 0x00FF
    println(y)

    //Decimal
    val dec1 = 20
    println(dec1)


  }

  /**
    * String Interpolator
    *  1. s string Interpolator : Scala will use the s string interpolator to process the literal. The sinterpolator
    * will evaluate each embedded expression, invoke toString on each result, and replace the embedded
    * expressions in the literal with those results.We can even place any expressions after $.
    *
    *  2. raw string Interpolator : The raw string interpolator behaves
    * like s, except it does not recognize character literal escape sequences
    *
    *  3. f string Interpolator : The f string interpolator allows you to attach printf-style formatting instructions
    *  to embedded expressions. You place the instructions after the expression, starting with a percent sign (%),
    *  using the syntax specified by java.util.Formatter.
    *
    */
  def stringInterpolation(): Unit ={
    // 1. s String Interpolator

    val language = "Scala"
    val sbtVersion = "1.2.8"

    println(s"$language langauage with $sbtVersion") // Scala langauage with 1.2.8
    println(s"Multiplication of 2 number anser is = ${10 * 10}.") // Multiplication of 2 number anser is = 100.
    println(s"No\\\\escape!") // No\\escape!

   //  2.  raw Interpolator
    println(raw"No\\\\escape!") // No\\\\escape!

   //  3. f Interpolator

    println(f"${math.Pi}%.3f") // 3.142
    println(f"${math.Pi}%.5f") // 3.14159


    val speech = s"""Number of error records: $language
                   |message: $sbtVersion""".stripMargin


    println(speech)

  }
}
