import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  // scct plugin settings
  lazy val s = Defaults.defaultSettings ++ Seq(ScctPlugin.instrumentSettings: _*)

  val appName         = "coverage"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc
  )

  val main = play.Project(appName, appVersion, appDependencies, settings = s).settings(
    parallelExecution in test := false
  )

}
