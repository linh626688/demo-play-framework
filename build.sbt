name := """botayroi"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.7"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean).settings {
  libraryDependencies ++= Seq(
    jdbc,
    javaWs,
    // https://adrianhurt.github.io/play-bootstrap/
    "com.adrianhurt" %% "play-bootstrap" % "1.0-P25-B3",
    "org.easytesting" % "fest-assert" % "1.4",
    "mysql" % "mysql-connector-java" % "5.1.38",
    "org.apache.commons" % "commons-io" % "1.3.2"
  )
}