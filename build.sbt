name := "discovery-scala-executable-example"
version := "0.1"
scalaVersion := "2.13.8"

Compile / mainClass := Some("inrae.application.Main")

libraryDependencies ++= Seq(
      "com.github.p2m2" %% "discovery" % "0.3.2d",
      "org.eclipse.rdf4j" % "rdf4j-sail" % "4.0.0",
      "org.eclipse.rdf4j" % "rdf4j-storage" % "4.0.0",
      "org.eclipse.rdf4j" % "rdf4j-tools-federation" % "4.0.0"  
      )

Global / onChangedBuildSource := ReloadOnSourceChanges
