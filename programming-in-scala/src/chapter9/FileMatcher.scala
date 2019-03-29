object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  // before refactor

  def filesEnding(query: String) =
    for(file <- filesHere; if file.getName.endsWith(query))
      yield file

  def filesContaining(query: String) =
    for(file <- filesHere; if file.getName.contains(query))
      yield file

  def filesRegex(query: String) =
    for(file <- filesHere; if file.getName.matches(query))
      yield file

  // after refactor

  def filesMatching(query: String,
                   matcher: (String, String) => Boolean) =
    for(file <- filesHere; if matcher(file.getName, query))
      yield file

  def filesEnding2(query: String) =
    filesMatching(query, _.endsWith(_))

  def filesContaining2(query: String) =
    filesMatching(query, _.contains(_))

  def fileRegex2(query: String) =
    filesMatching(query, _.matches(_))

  println(filesContaining(".scala"))
  println(filesContaining2(".scala"))

  // another refactor

  def filesEnding3(query: String) =
    filesMatching(_.endsWith(query))

  def filesContaining3(query: String) =
    filesMatching(_.contains(query))

  def filesRegex3(query: String) =
    files.matches(_.matches(query))

  def containtsNeg(nums: List[Int]) = nums.exists(_ < 0)
}