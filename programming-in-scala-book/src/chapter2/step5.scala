var i = 0

while(i < args.length) {
  println(args(i))
  i += 1
}


var s = 0

while(s < args.length) {
  if(s != 0)
    print(" ")
  print(args(s))
  s += 1
}

println()