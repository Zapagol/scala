

object Test {

  def main(args: Array[String]): Unit ={
    val list1 = List("Berry", "Bhaskar", "Kiran")

    val cool = Map("a" -> "aaa", "b" -> "bbb", "a" -> "ccc")
    println(cool("a"))

    val orgId = WholesalerIdentifiers.ALFRESSA_MEDICEO_SUZUKEN

    println(filterWxId("4615", orgId))

    println("019870709".substring(1))

    //2010-12-14 17:50:19
    val list = List(1, 2, 3)

  }

  private def filterWxId(org_id: String, wholesalerCategory: String): Boolean = {
    if (Option(org_id).getOrElse("").isEmpty) {
      false
    } else {
      wholesalerCategory.split(",").contains(org_id.trim)
    }
  }
}
