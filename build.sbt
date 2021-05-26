name := "discovery-scala-executable-example"
version := "0.1"
scalaVersion := "2.13.4"

mainClass in Compile := Some("inrae.application.Main")

libraryDependencies += "com.github.p2m2" %% "discovery" % "0.2.0"

Global / onChangedBuildSource := ReloadOnSourceChanges
