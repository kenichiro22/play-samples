package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index(service.HelloService.hello(" main application is ready.")))
  }
  
}