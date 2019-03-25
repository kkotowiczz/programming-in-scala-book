val numNames = Array("zero", "one", "two")

val oneTwoThree = List(1, 2, 3)

val oneTwo = List(1, 2)
val threeFour = List(3, 4)
val oneTwoThreeFour = oneTwo ::: threeFour

println(oneTwo + " and " + threeFour + " were not mutated")
println("Thus, " + oneTwoThreeFour + " is a new list")

val twoThree = List(2, 3)
val oneTwoThree1 = 1 :: twoThree

println(oneTwoThree1)

val oneTwoThree2 = 1 :: 2 :: 3 :: Nil
println(oneTwoThree2)