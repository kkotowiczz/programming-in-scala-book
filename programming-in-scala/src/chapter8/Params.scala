
def echo(args: String*) =
  for(arg <- args) println(arg)


echo("wiem")


val s = Array("whats", "up", "doc?")

echo(s: _*)

// named
def speed(distance: Float, time: Float): Float = distance / time

println(speed(100, 10))

// named params
println(speed(time = 20, distance = 5000))


// default params

def printTime(out: java.io.PrintStream = Console.out) =
  out.println("time: " + System.currentTimeMillis())


printTime()

def printTime2(out: java.io.PrintStream = Console.err, divisor: Int = 1) =
  out.println("time: " + System.currentTimeMillis() / divisor

printTime2()