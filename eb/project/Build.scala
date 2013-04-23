import sbt._
import Keys._
import play.Project._
import com.github.play2war.plugin._

object ApplicationBuild extends Build {

  val appName         = "eb"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    Play2WarKeys.servletVersion := "3.0"
  ).settings(Play2WarPlugin.play2WarSettings: _*)

}
