package service

object HelloService {
  def hello(msg: String) = {
    s"Hello, ${msg}"
  }
}
