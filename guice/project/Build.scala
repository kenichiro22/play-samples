import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "guice"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    "com.google.inject" % "guice" % "3.0",
    "com.tzavellas" % "sse-guice" % "0.7.1"    
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
  )

}
