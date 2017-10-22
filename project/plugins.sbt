resolvers ++= Seq(
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "spray repo" at "http://repo.spray.io",
  Classpaths.sbtPluginReleases
)

addSbtPlugin("io.spray" % "sbt-revolver" % "0.9.0")
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.8.0")
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.3.2")