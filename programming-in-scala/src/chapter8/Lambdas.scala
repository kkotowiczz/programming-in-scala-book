val increase = (x: Int) => {
  println("We")
  println("are")
  println("here")
  x + 1
}


println(increase(24))


val someNumbers = List(-11, -10, -5, 0, 5, 10)

someNumbers.foreach((x: Int) => println(x))

println(someNumbers.filter(x => x > 0))
println(someNumbers.filter(_ > 0))

val f = (_: Int) + (_: Int)

println(f(35, 6))

someNumbers.foreach(println _)

def sum(a: Int, b: Int, c: Int) = a + b + c

val a = sum _

val b = sum(1, _: Int, 6)