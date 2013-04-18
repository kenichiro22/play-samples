import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "multiproject"
  val appVersion      = "1.0-SNAPSHOT"

  val adminDeps = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm
  )
  
  val mainDeps = Seq()
  
  val common = Project(appName + "-common", file("modules/common"))

  lazy val commonWeb = play.Project(appName + "-common-web", appVersion, adminDeps, path = file("modules/common-web")).dependsOn(common)

  // admin module
  lazy val admin = play.Project(appName + "-admin", appVersion, adminDeps, path = file("modules/admin")).dependsOn(commonWeb)

  // main module
  lazy  val main = play.Project(appName, appVersion, mainDeps).settings(
      // Add your own project settings here      
    ).dependsOn(admin, common).aggregate(admin, commonWeb)

}
