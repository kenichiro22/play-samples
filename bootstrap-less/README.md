Bootstrap less sample
=======================

## 参考

* http://www.playframework.com/documentation/2.1.1/Tips
* http://www.playframework.com/documentation/2.1.1/AssetsLess

## 手順


1. boostrapのgithubからソースをダウンロードする
2. .lessファイルをassets\less\bootstrapにコピーする
3. assets\less\bootstrap\responsive.lessをbootstrap-responsive.lessに変更する
4. project/Build.scala に記述を追加
```scala
    // Only compile the bootstrap bootstrap.less file and any other *.less file in the stylesheets directory
    def customLessEntryPoints(base: File): PathFinder = (
        (base / "app" / "assets" / "stylesheets" / "bootstrap" * "bootstrap.less") +++
        (base / "app" / "assets" / "stylesheets" / "bootstrap" * "bootstrap-responsive.less") +++
        (base / "app" / "assets" / "stylesheets" * "*.less")
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      // Add your own project settings here   
  
      // twitter bootstrap less setting
      lessEntryPoints <<= baseDirectory(customLessEntryPoints)   
    )
```
5. ビューにてCSSを読み込む
> &lt;link rel="stylesheet" media="screen" href="@routes.Assets.at("stylesheets/bootstrap/bootstrap.min.css")" /><br>
> &lt;link rel="stylesheet" media="screen" href="@routes.Assets.at("stylesheets/bootstrap/bootstrap-responsive.min.css")" />

6. bootstrapのimgフォルダをpublic/images/bootstrapにコピーする

7. assets/less/variable.less のアイコン画像のパスを編集する
> @iconSpritePath:          "/assets/images/bootstrap/glyphicons-halflings.png";<br>
> @iconWhiteSpritePath:     "/assets/images/bootstrap/glyphicons-halflings-white.png";

8. bootstrapのjsフォルダをpublic/javascriptsにコピーする

9. ビューにてjsを読み込む
> <script src="@routes.Assets.at("javascripts/bootstrap.js")"></script>


コンパイルしたcssファイルはtarget\scala-2.10\resource_managed\main\public\stylesheets\bootstrap に作成される。
