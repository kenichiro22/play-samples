package models

import play.api.db.slick.Config.driver.simple._

case class User(id: Long, name: String, email: String)

object Users extends Table[User]("USER") {

  def id = column[Long]("id", O.PrimaryKey)
  def name = column[String]("name", O.NotNull)
  def email = column[String]("email", O.NotNull)
  def * = id ~ name ~ email <> (User.apply _, User.unapply _)
}