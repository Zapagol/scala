package org.zap.scala

import org.apache.spark.sql.SparkSession

trait SparkSessionLocal {

implicit val spark: SparkSession = SparkSession
  .builder()
  .master("local")
  .getOrCreate()

}
