# Dependency Injection sample with Guice

Guiceを使ったDIのサンプルです。

## 参考

* [Using Guice with Play! Framework 2.1 for easy Dependency Injection | 42 Engineering](http://eng.42go.com/play-framework-dependency-injection-guice/)

## 手順

1. project/Build.scala にて appDependencies に以下を追加します。mockitoはテストで使用します。

    "com.google.inject" % "guice" % "3.0",
    "com.tzavellas" % "sse-guice" % "0.7.1",
    "org.mockito" % "mockito-core" % "1.9.5" % "test"


2. Serviceを作成します。

    Interface
    trait UserService {
      def getAllUsers: List[User]
    }

    // Implementation
    class UserServiceImpl extends UserService {
      override def getAllUsers = {
        List(User(1L, "foo", "foo@example.com"),
          User(2L, "bar", "bar@example.com"),
          User(3L, "baz", "baz@example.com"))
      }
    }

3. Serviceを使用するControllerを作成します。

    import com.google.inject._

    @Singleton
    class Application @Inject()(userService: UserService) extends Controller {
      def index = Action {
        Ok(views.html.index(userService.getAllUsers))
      }
    }

4. Guiceのモジュールを作成し、Guiceを使用してControllerを取得するようにします。

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

5. getControllerInstance経由でControllerを取得するために、routesを変更します（@を付けます）。

    GET     /                           @controllers.Application.index

6. mockitoを使ってテストを書きます。Controllerを直接インスタンス化しています。

    "render the index page with mock" in {
      // SetUp
      val service = mock[UserService]
      val controller = new controllers.Application(service)

      service.getAllUsers returns List(User(1L, "foo", "foo@example.com"))

      // Exercise
      val home = controller.index()(FakeRequest())

      // Verify
      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain("foo")
      contentAsString(home) must not contain("bar")
    }