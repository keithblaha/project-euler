import sbt._
import Keys._

object EulerBuild extends Build {
  lazy val root = (project in file(".")).settings(
    name := "euler",
    organization := "com.keithblaha",

    scalaVersion := "2.11.6",

    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "2.2.1" % "test"
    ),

    testOptions in Test += Tests.Argument("-oD")
  )
}

