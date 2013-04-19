package test

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._
import org.specs2.mock.Mockito
import services.UserService
import models.User

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
class ApplicationSpec extends Specification with Mockito{
  
  "Application" should {

    "send 404 on a bad request" in {
      running(FakeApplication()) {
        route(FakeRequest(GET, "/boum")) must beNone
      }
    }

    "render the index page" in {
      running(FakeApplication()) {
        val home = route(FakeRequest(GET, "/")).get
        
        status(home) must equalTo(OK)
        contentType(home) must beSome.which(_ == "text/html")
        List("foo", "bar", "baz").foreach(contentAsString(home) must contain(_))
      }
    }

    "render the index page with mockito" in {
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
  }
}