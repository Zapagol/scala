package org.zap.scala

/**
  * you can provide default values for method arguments.
  * Because you have provided defaults, the consumer of your method can either
  * supply an argument to override the default or skip the argument, letting it use its default
  * value.
  *
  * Arguments are assigned from left to right.
  */
object DefaultValues extends App{

  class RestService{
    def post(userName: String = "admin",password: String = "admin", timeOut: Int = 200): Unit ={
      println(s"Connection made successfully for the user: $userName")
    }
    def makeConnection(timeOut: Int = 100, protocol: String): Unit ={
      println(s"Connection made successfully. Protocol : $protocol")
    }
    def delete(url: String, timOut: Int): Unit ={
      println(s"Delete successfully. Url : $url")
    }
    def get(string: String*): Unit ={
      println(s"Response code : 200")
    }
    // won't compile
    /*def get(string: String*, timeOut: Int): Unit ={

    }*/
    def get1(timeOut: Int, string: String*): Unit ={
      println(s"Response code : 200")
    }
  }

  //post method can now call in the following ways
  val restService = new RestService
  restService.post()
  restService.post("user")
  restService.post("user", "pwd")
  restService.post("user", "pwd", 500)

  //without parameter parantheses lead to an error
  //restService.post -- won't compile

  //named parameters
  restService.post(password = "pwd")
  restService.post(timeOut = 200)

  //mixin
  //restService.makeConnection(2000)  -- won't compile
  //restService.makeConnection("https") -- won't compile
  restService.makeConnection(protocol = "https")

  /*
    Parameters names when calling method.This is useful when several parameters
    have same type.
   */
  restService.delete(url = "http://restService:5050/", timOut = 200)
  restService.delete(timOut = 100, url = "http://restService:5050/")

  /*
    Variable argument fields.Method that can take variable number of arguments.
    1. *
    2. _* : to adapt seq
   */
  restService.get()
  restService.get("admin")
  restService.get("admin", "admin")
  restService.get("admin", "admin", "http")

}
