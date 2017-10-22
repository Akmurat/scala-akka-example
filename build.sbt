import com.typesafe.sbt.SbtScalariform.ScalariformKeys

ScalariformKeys.preferences := {
  import scalariform.formatter.preferences._
  FormattingPreferences()
    .setPreference(RewriteArrowSymbols, true)
    .setPreference(AlignParameters, true)
    .setPreference(AlignArguments, true)
    .setPreference(AlignSingleLineCaseStatements, true)
    .setPreference(DanglingCloseParenthesis, Preserve)
    .setPreference(DoubleIndentConstructorArguments, false)
}

lazy val commonSettings = Defaults.coreDefaultSettings ++ Seq(
  organization := "com.shadowsmind",
  version := "0.0.1",
  scalaVersion := "2.12.3",
  scalacOptions ++= List("-unchecked", "-deprecation", "-encoding", "UTF8", "-feature")
)

val akkaVersion           = "2.4.19"
val akkaHttpVersion       = "10.0.10"
val akkaHttpCircleVersion = "1.18.0"
val circleVersion         = "0.8.0"
val macWireVersion        = "2.3.0"
val typesafeConfigVersion = "1.3.2"
val pureConfigVersion     = "0.8.0"
val hikariCPVersion       = "2.7.2"
val postgresDriverVersion = "42.1.4"
val flyWayVersion         = "4.2.0"
val slickVersion          = "3.2.1"
val slickPgVersion        = "0.15.3"

val scalaTestVersion      = "3.0.4"
val scalacheckVersion     = "1.13.5"
val scalaMeterVersion     = "0.8.2"

val dependencies = Seq(
  "com.typesafe.akka"        %% "akka-actor"           % akkaVersion,
  "com.typesafe.akka"        %% "akka-stream"          % akkaVersion,
  "com.typesafe.akka"        %% "akka-http-spray-json" % akkaHttpVersion,
  "com.softwaremill.macwire" %% "macros"               % macWireVersion % "provided",
  "com.typesafe"             %  "config"               % typesafeConfigVersion,
  "com.github.pureconfig"    %% "pureconfig"           % pureConfigVersion
)

val testDependencies = Seq(
  "org.scalatest"       %% "scalatest"           % scalaTestVersion  % "test",
  "org.scalacheck"      %% "scalacheck"          % scalacheckVersion % "test",
  "com.typesafe.slick"  %% "slick-testkit"       % slickVersion      % "test",
  "com.storm-enroute"   %% "scalameter"          % scalaMeterVersion % "test",
  "com.typesafe.akka"   %% "akka-testkit"        % akkaVersion       % "test",
  "com.typesafe.akka"   %% "akka-stream-testkit" % akkaVersion       % "test",
  "com.typesafe.akka"   %% "akka-http-testkit"   % akkaHttpVersion   % "test"
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    name := "example-app",
    libraryDependencies ++= dependencies ++ testDependencies
  )