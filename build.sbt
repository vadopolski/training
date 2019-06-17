name := "training"

version := "0.1"

scalaVersion := "2.12.8"

scalacOptions := Seq(
  "-encoding",
  "utf8",
  "-feature",
  "-unchecked",
  "-deprecation",
  "-target:jvm-1.8",
  "-Ypartial-unification",
  "-language:_",
  "-Xexperimental"
)

libraryDependencies += "org.scalactic"  %% "scalactic"   % "3.0.5"
libraryDependencies += "org.scalatest"  %% "scalatest"   % "3.0.5" % "test"
libraryDependencies += "org.scalacheck" %% "scalacheck"  % "1.13.4" % "test"
libraryDependencies += "org.mockito"    % "mockito-core" % "1.9.5" % "test"
libraryDependencies += "commons-io" % "commons-io" % "2.6"