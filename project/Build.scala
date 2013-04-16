import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "bootstrap-less"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm
  )

  // Only compile the bootstrap bootstrap.less file and any other *.less file in the stylesheets directory
  def customLessEntryPoints(base: File): PathFinder = (
      (base / "app" / "assets" / "stylesheets" / "bootstrap" * "bootstrap.less") +++
      (base / "app" / "assets" / "stylesheets" / "bootstrap" * "bootstrap-responsive.less") +++
      (base / "app" / "assets" / "stylesheets" * "*.less")
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here   

    // twitter bootstrap less setting
    lessEntryPoints <<= baseDirectory(customLessEntryPoints)   
  )

}
