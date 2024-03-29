import scala.collection.mutable

val treasureMap = mutable.Map[Int, String]()
treasureMap += (1 -> "Go to island.")
treasureMap += (2 -> "Find big X on the ground.")
treasureMap += (3 -> "Dig.")

println(treasureMap(2))

val romanNumeral = Map (
  1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
)

println(romanNumeral(4))