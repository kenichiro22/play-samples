import models.{Users, User}
import play.api._
import play.api.db.slick.DB

import play.api.db.slick.Config.driver.simple._

import play.api.Play.current

/**
 * Created with IntelliJ IDEA.
 * User: ktana
 * Date: 13/04/17
 * Time: 9:51
 * To change this template use File | Settings | File Templates.
 */
object Global extends GlobalSettings {

  override def onStart(app: Application) {
    Logger.info("Application has started")

    DB.withSession{ implicit session =>
      Users.ddl.drop
      Users.ddl.create
      Seq(
        User(1L, "foo", "foo@example.com"),
        User(2L, "bar", "bar@example.com"),
        User(3L, "baz", "baz@example.com")
      ).foreach(Users.insert)
    }
  }
}