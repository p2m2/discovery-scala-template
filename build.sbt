name := "discovery-scala-executable-example"
version := "0.1"
scalaVersion := "2.13.4"

mainClass in Compile := Some("inrae.application.Main")

libraryDependencies += "org.apache.logging.log4j" % "log4j-api" % "2.14.0"
libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.14.0"
libraryDependencies += "com.github.p2m2" %% "discovery" % "v0.2.0"

Global / onChangedBuildSource := ReloadOnSourceChanges
