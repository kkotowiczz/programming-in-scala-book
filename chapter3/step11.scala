def printArgs(args: Array[String]): Unit = {
  for (arg <- args)
    println(arg)
}

def printArgs2(args: Array[String]): Unit = {
  args.foreach(println)
}

def formatArgs (args: Array[String]): String = args.mkString("\n")