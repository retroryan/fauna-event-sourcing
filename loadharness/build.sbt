import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "fauna",
      scalaVersion := "2.12.6",
      version      := "0.1.0"
    )),
    name := "loadharness",
    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= Seq(
      "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.0",
      "io.gatling"            % "gatling-test-framework"    % "2.3.0",
      "io.circe" %% "circe-core" % "0.9.0-M1",
      "io.circe" %% "circe-parser" % "0.9.0-M1",
      "io.circe" %% "circe-generic" % "0.9.0-M1"
    )
  )
