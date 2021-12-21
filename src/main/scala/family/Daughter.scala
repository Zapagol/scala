package family

class Daughter {
  val father = new Father
  //father.creditCard -- this won't compile
  father.debitCard() // this will compile
}
