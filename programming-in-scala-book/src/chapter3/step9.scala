import scala.collection.mutable

val pair = (99, "Luftballons")

println(pair._1)
println(pair._2)

var jetSet = Set("Boeing", "Airbus")

jetSet += "Cessna"

println(jetSet.contains("Lear"))


val movieSet = mutable.Set("Hitch", "Poltergeist")

movieSet += "Shrek"

println(movieSet)

