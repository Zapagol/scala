package org.zap.scala.collections

/**
  * S.length is the length of the string in characters;
  * S.substring(i) returns the part of the string starting at index i.
  * S.substring(i,j) returns the part of the string starting at index i and going up to index j-1.
    You can write S.slice(i,j) instead.
  * S.contains(T) returns true if T is a substring of S;
  * S.indexOf(T) returns the index of the first occurrence of the substring T in S (or -1);
  * S.indexOf(T, i) returns the index of the first occurrence after index i of the substring T in S (or -1);
  * S.toLowerCase and S.toUpperCase return a copy of the string with all characters converted to lower or upper case;
  * S.capitalize returns a new string with the first letter only converted to upper case;
  * S.reverse returns the string backwards;
  * S.isEmpty is the same as S.length == 0;
  * S.nonEmpty is the same as S.length != 0;
  * S.startsWith(T) returns true if S starts with T;
  * S.endsWith(T) returns true if S ends with T;
  * S.replace(c1, c2) returns a new string with all characters c1 replaced by c2;
  * S.replace(T1, T2) returns a new string with all occurrences of the substring T1 replaced by T2;
  * S.trim returns a copy of the string with white space at both ends removed;
  * S.format(arguments) returns a string where the percent-placeholders in S have been replaced by
    the arguments (see example below);
  * S.split(T) splits the string into pieces and returns an array with the pieces. T is a regular
    expression (not explained here). To split around white space, use S.split("* s+").
  */
object Strings extends App {

  val str = "Hello Scala!"
  println(str.charAt(7)) // c
  println(str.codePointAt(5))
  println(str.compareTo("Hello Scal"))
  println(str.intern()) // Hello Scala!

  str.toArray.foreach(println)

  // Regular Expressions

  // create a regex with '.r'
  val numPattern1 = "[0-9]+".r                     // Regex = [0-9]+

  // use the regex on `address`
  val address1 = "123 Main Street"                 // "123 Main Street"
  val match1 = numPattern1.findFirstIn(address1)    // Some(123)

  // create a regex with Regex class
  import scala.util.matching.Regex
  val numPattern = new Regex("[0-9]+")                  // Regex = [0-9]+ 222
  val address2 = "123 Main Street Unit 639"              // "123 Main Street Unit 639"

  // `findAllIn` returns an iterator
  val matches = numPattern.findAllIn(address2)           // non-empty iterator

  // force the result to a sequence
  val matches1 = numPattern.findAllIn(address2).toSeq     // Stream(123, ?)
  val matches2 = numPattern.findAllIn(address2).toArray   // Array(123, 639)
  val matches3 = numPattern.findAllIn(address2).toList    // List(123, 639)

  val regex = "[0-9]".r                        // Regex = [0-9]
  regex.replaceAllIn("123 Main Street", "x")   // "xxx Main Street"

  "123 Main Street".replaceAll("[0-9]", "x")   // "xxx Main Street"
  "Hello world".replaceFirst("l", "e")         // "Heelo world"
  "99 Luft Balloons".replaceAll("9", "1")      // "11 Luft Balloons"
  "99 Luft Balloons".replaceFirst("9", "1")    // "19 Luft Balloons"

  // create a regex
  val pattern = "([A-Za-z]+) (\\d+), (\\d+)".r

  // apply the regex to a string
  val pattern(month, day, year) = "June 22, 2018"

}
