lazy val root = {
  project
    .in(file("."))
    .aggregate(core, app)
    .enablePlugins(TutPlugin)
    .settings(
      resolvers += Resolver.sonatypeRepo("releases"),
      scalafmtOnCompile := true,
      addCommandAlias("build", ";test:compile"),
      addCommandAlias("rebuild", ";reload;test:compile"),
      addCommandAlias("retest", ";reload;test:test"),
      addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.6"),
      organization := "com.example",
      name := "$name$",
      scalaVersion in ThisBuild := "2.12.4",
      onLoad in Global := { s => "dependencyUpdates" :: s }
    )
}

lazy val core = {
  project
}

lazy val app = {
  project
    .dependsOn(core % "test->test;compile->compile")
    .enablePlugins(BuildInfoPlugin)
    .settings(
      buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
      buildInfoPackage := "buildinfo",
      buildInfoOptions += BuildInfoOption.BuildTime,
      buildInfoOptions += BuildInfoOption.ToJson,
      mainClass in run := Some("com.example.fnord.app.Main"),
      mainClass in reStart := Some("com.example.fnord.app.Main")
    )
}

// Turn on/off nagging compiler warnings from sbt-tpolecat, for debugging purposes:
//scalacOptions.in(app, Compile) ~= filterConsoleScalacOptions
