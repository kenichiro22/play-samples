package controllers

import play.api._
import play.api.mvc._
import play.api.db.slick.DB

import play.api.Play.current

import play.api.db.slick.Config.driver.simple._
import models.Users

object Application extends Controller {
  
  def index = Action {
    DB.withSession{ implicit session =>
      val users = Query(Users).list()
      Ok(views.html.index(users))
    }
  }
  
}