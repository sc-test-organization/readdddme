import com.typesafe.sbt.SbtGit.GitKeys._
import com.typesafe.sbt.SbtNativePackager.autoImport.NativePackagerHelper._
import play.sbt.PlayImport.{ehcache, guice}

name := """sso-account"""

version := IO.read(new File("version")).replace("\n", "")

scalaVersion := "2.12.7"

routesGenerator := InjectedRoutesGenerator

PlayKeys.devSettings := Seq("play.server.http.idleTimeout" -> "300 seconds")

addCompilerPlugin("org.psywerx.hairyfotr" %% "linter" % "0.1.17")
val reactiveMongoVer = "0.13.0"
libraryDependencies ++= Seq(
  ws, guice, ehcache, filters,

  // External dependencies
  "net.codingwell" %% "scala-guice" % "4.1.0",
  "org.reactivemongo" %% "reactivemongo" % reactiveMongoVer,
  "org.reactivemongo" %% "reactivemongo-iteratees" % reactiveMongoVer,
  "commons-validator" % "commons-validator" % "1.6",
  "org.webjars" % "swagger-ui" % "3.13.0",
  "com.sksamuel.elastic4s" %% "elastic4s-http" % "5.4.6",
  "com.sksamuel.elastic4s" %% "elastic4s-json4s" % "5.4.6",
  "net.logstash.logback" % "logstash-logback-encoder" % "4.11",
  "org.lyranthe.prometheus" %% "client" % "0.9.0-M4",

  // Internal dependencies
  "com.sharecare.sso" %% "common-lib" % "1.29.0",
  "com.sharecare.sso" %% "bootstrap-utilities" % "1.1.0",
  "com.sharecare.crypto-services" % "cryptography-java" % "1.0.0"
)


updateOptions := updateOptions.value.withLatestSnapshots(false)
updateOptions := updateOptions.value.withCachedResolution(true)

val artifactRepo = "https://nexus.admin.sharecare.com"
resolvers ++= Resolver.jcenterRepo +: {
  Seq("Nexus" at s"$artifactRepo/repository/maven-public/")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
