package org.zap.scala

object AllPatterns extends App {

  // 1. Constants
  val x: Any = "Pattern Matching"

  val constants = x match {
    case 1 => "Number"
    case "Pattern Matching" => "String"
    case true => "Boolean"
    case Nil => "the empty list"
    case AllPatterns => "Singleton Object"
  }

  // 2 - Match Anything
  // 2.1 - Wild Card
  val matchAnything = x match {
    case _ => "Wild Card Match"
  }

  // 2.2 - Variable
  val matchVariable = x match {
    case something => s"Variable match anything. Found $something"
  }

  // variable or constant
  import math.{Pi,E}

  E match {
    case Pi => "Pi = " + Pi
    case _ => "Don't know"
  }

  //Output : Don't know
  // How does the Scala compiler know that Pi is a constant imported from scala.math, and not a variable
  //that stands for the selector value itself? Scala uses a simple lexical rule for disambiguation: a simple
  //name starting with a lowercase letter is taken to be a pattern variable; all other references are taken to
  //be constants.Here the compiler will not even let you add a default case at all. Since pi is a variable pattern, it will
  //match all inputs, and so no cases following it can be reached:

  E match {
    case pi => "Pi = " + pi
  }


  // 3. tuples
  val tuple = ("Google", "Sundar Pichai")

  val tupleMatch = tuple match {
    case ("Google", "Sundar Pichai") => "Founded in 1998"
    case (_, "Sundar Pichai") => "Current CEO of Google"
    case ("Google", _) => "Google founded in 1998 and founder is Larry Page and "
    case (something, "Sundar Pichai") => s"$something found with Sundar Pichai"
    case ("Google", something) => s"$something found with Google"
  }

  val nestedTuple = (10, (20, 40))

  val nestedTupleMatch = nestedTuple match {
    case (_, (20, v)) =>
  }

  // 4. Case class - constructor pattern
  // PMs can be nested with case class as well
  case class Fruit(name: String, vitamins: List[String])
  val mangoFruit = Fruit("Mango", List("A", "B"))

  mangoFruit match {
    case Fruit("Mango", _) =>
    case Fruit("Mango", List(_,_)) =>
  }

  // 5. List Patterns

  val list = List(10,20,30,40)
  list match {
    case List(10,_,_,_) => println(list.head)// Extractor - advanced
    case List(10, _*) => // list of arbitrary length
    case List(10, _*) =>
    case 1 :: List(_) => // infix pattern
    case List(10,20,30) :+ 42 => // infix pattern
  }

  // 6 - type specifiers
  val typeSpecifier: Any = 121
  typeSpecifier match {
    case _: List[Int] => println("I am holding list of Integers")
    case _: Int => println("I can take only Integers")
    case _: String => println("I can take only Strings")
    case _ =>
  }

  // 7 - name binding
  val stringList = List("Amazon", "Facebook", "PayTM")
  stringList match {
    case nonEmptyList @ List(_,_,_) => // name binding - use the name later
    case List("Amazon", facebook @_, _) => // name binding inside nested patterns
  }

  // 8 - MultiPatterns
  stringList match {
    case List("Amazon", _) | List(_,"Facebook",_) => // Compound pattern/multi pattern
  }

  // 9 - if guard

  val compNameList = List("MicroSoft", "Google", "PayTM")
  compNameList match {
    //case compName if compName.isEmpty =>
    case comName if comName.length > 4 =>
    case _ => "No Match, Sorry!"
  }

  // 10 - Type erasure
  // Scala uses the erasure model of generics, just like Java does. This means that no information about type
  //arguments is maintained at runtime.Scala uses the erasure model of generics, just like Java does.
  // This means that no information about type arguments is maintained at runtime.
  // The only exception to the erasure rule is arrays, because they are handled specially in Java as well as in
  //Scala.

  def isIntList(x: Any) = x match {
    case listInt: Array[Int] => true
    case _ => false
  }

  println(isIntList(List(1,2)))
  println(isIntList(List("Scala", "Java")))

  def isIntArray(x: Any) = x match {
    case listInt: Array[Int] => true
    case _ => false
  }

  println(isIntList(Array(1,2)))
  println(isIntList(Array("Scala", "Java")))

  // 11 - Pattern Overlaps : Patterns are tried in the order in which they are written.

  def number(x: Int) = x match {
    case _ => "Nothing matched"
    case 1 => "One"
    case 2 => "Two"
    case 3 => "Three"
  }
  // output - Nothing matched

  println(number(2))

  // 12 - Option Type

  val ceo = Map("MicroSoft" -> "Satya Nadella", "Google" -> "Sundar Pichai")
  def getCEOs(x: Option[String]) = x match {
    case Some(x) => x
    case None => "I don't know. Please Google"
  }

  println(getCEOs(ceo get "MicroSoft"))
  println(getCEOs(ceo get "Facebook"))


  abstract class Notification

  case class Email(sender: String, title: String, body: String) extends Notification
  case class SMS(caller: String, message: String) extends Notification
  case class VoiceRecording(contactName: String, link: String) extends Notification

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(sender, title, _) =>
        s"You got an email from $sender with title: $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"You received a Voice Recording from $name! Click the link to hear it: $link"
    }
  }
  val someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

  println(showNotification(someSms))  // prints You got an SMS from 12345! Message: Are you there?

  println(showNotification(someVoiceRecording))  // you received a Voice Recording from Tom!
  // Click the link to hear it: voicerecording.org/id/123

  def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
    notification match {
      case Email(sender, _, _) if importantPeopleInfo.contains(sender) =>
        "You got an email from special someone!"
      case SMS(number, _) if importantPeopleInfo.contains(number) =>
        "You got an SMS from special someone!"
      case other =>
        showNotification(other) // nothing special, delegate to our original showNotification function
    }
  }

  val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")

  val someSms1 = SMS("123-4567", "Are you there?")
  val someVoiceRecording1 = VoiceRecording("Tom", "voicerecording.org/id/123")
  val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
  val importantSms = SMS("867-5309", "I'm here! Where are you?")

  println(showImportantNotification(someSms1, importantPeopleInfo)) //prints You got an SMS from 123-4567! Message: Are you there?
  println(showImportantNotification(someVoiceRecording1, importantPeopleInfo)) //prints You received a Voice Recording
  // from Tom! Click the link to hear it: voicerecording.org/id/123
  println(showImportantNotification(importantEmail, importantPeopleInfo)) //prints You got an email from special someone!

  println(showImportantNotification(importantSms, importantPeopleInfo)) //prints You got an SMS from special someone!

  "a" match {
    case name if name.length > 2 && name.substring(1,2).equals("b") => println(s"${name.length} and ${name.substring(1,2)}")
    case name if name.length > 2 => println(s"${name.length}")
    case _ => println("Nothing----->")
  }
}
