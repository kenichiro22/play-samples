Code coverage tool(scct plugin) sample 
=====================================

## 手順

1. project/plugins.sbt に以下の記述を追加します。

	resolvers += "scct-github-repository" at "http://mtkopone.github.com/scct/maven-repo"

	addSbtPlugin("reaktor" % "sbt-scct" % "0.2-SNAPSHOT")

2. project/Build.scala に以下の記述を追加します。

	lazy val s = Defaults.defaultSettings ++ Seq(ScctPlugin.instrumentSettings: _*)

	val main = play.Project(appName, appVersion, appDependencies, settings = s).settings(
	  parallelExecution in test := false
	)

3. ビルドを実行します。target/scala-2.10/coverage-report/ にカバレッジレポートが作成されます。
> play clean scct:test

4. Jenkinsで実行する場合には、Coberturaプラグインをインストールし、レポートとして以下を target/scala-2.10/coverage-report/coverage.xml を読込みます。

## 参考
[scct - Scala Code Coverage Tool](http://mtkopone.github.io/scct/)
