package controllers

import play.api.mvc._
import play.api.libs.json.Json
import play.api.i18n.Messages
import play.api.Play.current

object Application extends Controller {

  def index = Action {
    implicit request =>
      Ok(views.html.index())
  }

  def phones(phoneId: String) = Action {
    implicit request =>
      Redirect(routes.Assets.at(s"phones/${phoneId}.json"))
  }

  def messages = Action {
    implicit request =>
      Ok(Json.toJson(Messages.messages.get("default"))).as(JAVASCRIPT)
  }
}