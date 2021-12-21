name := "Scala"

version := "0.1"

scalaVersion := "2.11.12"

lazy val sparkVersion = "2.3.0"
lazy val akkaVersion = "2.5.31"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion
)