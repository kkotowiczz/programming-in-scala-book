// implicit
args.foreach(arg => println(arg))
// explicit
args.foreach((arg: String) => println(arg))

for(arg <- args)
  println(arg)