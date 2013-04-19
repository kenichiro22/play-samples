package services

import models.User

trait UserService {
  def getAllUsers: List[User]
}

class UserServiceImpl extends UserService {
  override def getAllUsers = {
    List(User(1L, "foo", "foo@example.com"),
      User(2L, "bar", "bar@example.com"),
      User(3L, "baz", "baz@example.com"))
  }
}