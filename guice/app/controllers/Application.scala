package controllers

import play.api._
import play.api.mvc._
import com.google.inject._
import services.UserService

@Singleton
class Application @Inject()(userService: UserService) extends Controller {
  
  def index = Action {
    Ok(views.html.index(userService.getAllUsers))
  }

}