name := "discovery-scala-executable"
version := "0.1"
scalaVersion := "2.13.4"


mainClass in Compile := Some("inrae.application.Main")

resolvers ++= Seq(
  Resolver.bintrayRepo("hmil", "maven"),
  Resolver.sonatypeRepo("public")
)

resolvers ++= Seq("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "releases" at "https://oss.sonatype.org/content/repositories/public/")

libraryDependencies ++= Seq(
  "com.github.p2m2" %% "discovery" % "develop-SNAPSHOT",
)

Global / onChangedBuildSource := ReloadOnSourceChanges
