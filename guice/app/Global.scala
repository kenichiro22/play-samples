import com.google.inject.Guice
import com.tzavellas.sse.guice.ScalaModule
import play.api.GlobalSettings
import services.{UserServiceImpl, UserService}

object Global extends GlobalSettings {
  private lazy val injector = {
    Guice.createInjector(new Module)
  }

  override def getControllerInstance[A](clazz: Class[A]) = {
    injector.getInstance(clazz)
  }
}

class Module extends ScalaModule {
  def configure() {
    bind[UserService].to[UserServiceImpl]
  }
}