
name := "Scalaprograms"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.4.1"
)

libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.7"
libraryDependencies += "org.json4s" %% "json4s-core" % "3.6.7"

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

lazy val root = (project in file(".")).
  settings(
    name := "Scalaprograms"
  ).
  enablePlugins(AssemblyPlugin)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
