val Http4sVersion = "0.18.0-M9"
val LogbackVersion = "1.2.3"
val CirceVersion = "0.9.1"
val JournalVersion = "3.0.19"
val DoobieVersion = "0.5.0-M14"
val ScalaTestVersion = "3.0.5"
val ScalaCheckVersion = "1.13.5"

// TODO create version setting and move some of these out of core
libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-blaze-server",
  "org.http4s" %% "http4s-blaze-client",
  "org.http4s" %% "http4s-circe",
  "org.http4s" %% "http4s-dsl"
).map(_ % Http4sVersion)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % ScalaTestVersion % "test",
  "org.scalacheck" %% "scalacheck" % ScalaCheckVersion % "test"
)

libraryDependencies ++= Seq(
  "io.verizon.journal" %% "core" % JournalVersion,
  "ch.qos.logback" % "logback-classic" % LogbackVersion
)

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % CirceVersion)

libraryDependencies ++= Seq(
  "org.tpolecat" %% "doobie-core",
  "org.tpolecat" %% "doobie-hikari",
  "org.tpolecat" %% "doobie-h2"
).map(_ % DoobieVersion)
