package family

class Father {
  protected def creditCard(){
    println("Father credit card")
  }
  private[family] def debitCard(){
    println("Father debit card")
  }
}
