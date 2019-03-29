name := "programming-scala"

version := "0.1"

scalaVersion := "2.12.8"
(unmanagedResourceDirectories in Compile) := (unmanagedResourceDirectories in Compile).value.filter(_.getName.startsWith("scripts"))
Compile/mainClass := Some("com.github.kkotowiczz.chapter10.ChapterTenMain")

