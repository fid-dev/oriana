name := "oriana"

description := "Oriana is a small layer on top of slick that allows easier access to the database. It allows peudo-" +
  "syntactic methods to inject a database context into arbitrary code, and simplifies deployment, updates and " +
  "initialization."

organization := "com.github.norwae"

version := "1.0.2-SNAPSHOT"

scalaVersion := "2.11.8"

publishMavenStyle := true

libraryDependencies ++= {
  val akkaVersion = "2.4.10"
  val slickVersion = "3.1.1"
  Seq(
    "org.scala-lang" % "scala-reflect" % scalaVersion.value,

    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,

    "com.typesafe.slick" %% "slick" % slickVersion,
    "com.typesafe.slick" %% "slick-hikaricp" % slickVersion,

    "com.h2database" % "h2" % "1.4.191" % "test",
    "org.scalatest" %% "scalatest" % "2.2.6" % "test"
  )
}

scmInfo := Some(ScmInfo(url("https://github.com/norwae/oriana"), "scm:git:https://github.com/Norwae/oriana.git", Some("scm:git:ssh://git@github.com:Norwae/oriana.git")))

pomExtra :=
  Seq(<licenses>
    <license>
      <name>BSD 2-Clause</name>
      <url>https://github.com/Norwae/oriana/blob/master/LICENSE</url>
      <distribution>repo</distribution>
    </license>
  </licenses>, <developers>
    <developer>
      <name>Stefan Schulz</name>
      <email>schulz.stefan@gmail.com</email>
    </developer>
  </developers>, <url>https://github.com/norwae/oriana</url>)