// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository 
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("play" % "sbt-plugin" % "2.1.0")

// Scct plugin
resolvers += "scct-github-repository" at "http://mtkopone.github.com/scct/maven-repo"
 
addSbtPlugin("reaktor" % "sbt-scct" % "0.2-SNAPSHOT")
