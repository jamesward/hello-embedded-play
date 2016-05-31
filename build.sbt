name := "hello-embedded-play"

scalaSource in Compile := baseDirectory.value / "app"

resourceDirectory in Compile := baseDirectory.value / "app"

scalaVersion := "2.11.8"

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

cancelable in Global := true

libraryDependencies := Seq(
  "com.typesafe.play" %% "play-netty-server" % "2.5.3",
  "org.slf4j" % "slf4j-simple" % "1.7.21"
)

enablePlugins(JavaAppPackaging)
