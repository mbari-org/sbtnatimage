ThisBuild / scalaVersion := "3.0.1"

def baseNativeImageOptions = List(
  "--initialize-at-build-time",
  "--no-fallback",
  "--native-image-info",
  "--verbose"
  // of course, your real app will likely need more options
) ++ {
  // adhoc but effective mechanism to indicate --static in native.yml for the linux target
  if (sys.env.contains("WITH_STATIC")) List("--static") else List.empty
}

lazy val sbtnatimage = project
  .enablePlugins(NativeImagePlugin)
  .settings(
    Compile / mainClass := Some("pkg.Test"),
    nativeImageOptions ++= baseNativeImageOptions,
    Global / lintUnusedKeysOnLoad := false,
    // the above line to avoid "there's a key that's not used by any other settings/tasks"
    // related with the next line:
    nativeImageVersion := "21.1.0"
  )
