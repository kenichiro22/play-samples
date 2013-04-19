Sample application with Sclik
=====================================

## 参考

* https://github.com/freekh/play-slick

## 手順

playは2.1.1を使う

1. project/Build.scala のappDependencies に play-slick プラグインを追加します。
```scala
    val appDependencies = Seq(
      jdbc,
      "com.typesafe.play" %% "play-slick" % "0.3.2"
    )
```

2. モデルクラスを定義します（importに注意）。
```scala
    package models

    import play.api.db.slick.Config.driver.simple._

    case class User(id: Long, name: String, email: String)

    object Users extends Table[User]("USER") {

      def id = column[Long]("id", O.PrimaryKey)
      def name = column[String]("name", O.NotNull)
      def email = column[String]("email", O.NotNull)
      def * = id ~ name ~ email <> (User.apply _, User.unapply _)
    }
```

3.  Usersを使用して検索を行います（importに注意）。
```scala
    package controllers

    import models._

    import play.api._
    import play.api.mvc._
    import play.api.Play.current

    import play.api.db.slick.DB
    import play.api.db.slick.Config.driver.simple._

    object Application extends Controller {
      def index = Action {
        DB.withSession{ implicit session =>
          Ok(views.html.index(Query(Users).list()))
        }
      }
    }
```
