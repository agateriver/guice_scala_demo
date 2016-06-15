name := """guice_scala"""

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= {
    Seq(
        "org.scalatest" %% "scalatest" % "2.2.6" % "test",
        "com.google.inject" % "guice" % "3.0",
        "com.tzavellas" %% "sse-guice" % "0.7.2"
    )
}
