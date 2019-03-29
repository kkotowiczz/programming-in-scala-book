def fileLines(file: java.io.File) =
  scala.io.Source.fromFile(file).getLines.toList

val filesHere = (new java.io.File(".")).listFiles

def grep(pattern: String) =
  for (
    file <- filesHere
    if file.getName.endsWith(".scala");
    line <- fileLines(file)
    if line.trim.matches(pattern)
  ) println(file + ": " + line.trim)

grep(".*gcd.*")


def scalaFiles =
  for {
    file <- filesHere
    if file.getName.endsWith(".scala")
  } yield file


val fileList = scalaFiles

println(fileList)

val forLineLengths =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
    } yield trimmed

forLineLengths.foreach(println)

val n = 3
val half =
  if (n % 2 == 0)
    n / 2
  else throw new RuntimeException("n must be even")