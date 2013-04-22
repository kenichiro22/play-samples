package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index())
  }

  def phones(phoneId: String) = Action {
    Redirect(routes.Assets.at(s"phones/${phoneId}.json"))
  }
}