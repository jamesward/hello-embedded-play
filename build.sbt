enablePlugins(JavaAppPackaging)

name := "hello-embedded-play"

scalaSource in Compile := baseDirectory.value / "app"

resourceDirectory in Compile := baseDirectory.value / "app"

scalaVersion := "2.13.1"

cancelable in Global := true

libraryDependencies := Seq(
  "com.typesafe.play" %% "play-akka-http-server" % "2.8.0",
  "org.slf4j" % "slf4j-simple" % "1.7.21"
)
