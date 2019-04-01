
  println(List(1, 2, 3) map (_ + 1))

  val words = List("the", "quick", "brown", "fox")

  println(words map (_.length))

  println(words map (_.toList.reverse.mkString))

  val wordsList = words.map(_.toList)

  println(wordsList)
  println(words flatMap(_.toList))


  val listRange = List.range(1, 5) flatMap (
    i => List.range(1, i) map (j => (i, j))
  )

  // alternative approach

  val listRangeFor = for (i <- List.range(1, 5); j <- List.range(1, i)) yield (i, i)

  println(listRange)
  println(listRangeFor)

  println(List(1, 2, 3, 4, 5) filter (_ % 2 == 0))

  println(words filter (_.length == 3))

  println(List(1, 2, 3, 4, 5) partition(_ % 2 == 0))

  List(1, 2, 3, -4, 5) takeWhile(_ > 0)
  List(1, 2, 3, -4, 5) dropWhile(_ > 0)

  def hasZeroRow(m: List[List[Int]]) = m exists (row => row forall (_ == 0))

  def sum(xs: List[Int]): Int = (0 /: xs) (_ + _)

  println(sum(List(1, 2, 3, 4)))

  def product(xs: List[Int]): Int = (1 /: xs) (_ * _)

  println(product(List(1, 2, 3, 4)))

  println(("" /: words) (_ + " " + _))
  println((words.head /: words.tail) (_ + " " + _))

  println(List.fill(5)('a'))

  println(List.fill(2, 3, 6)('b'))

  val squares = List.tabulate(5)(n => n * n)
  val multiplication = List.tabulate(5, 5)(_ * _)
  println(squares)
  println(multiplication)

  val zippedList = (List(10, 20), List(3, 4, 5)).zipped.map(_ * _)
  println(zippedList)

  val zippedStrings = (List("abc", "de"), List(3, 2))

  println(zippedStrings.zipped.exists(_.length == _))
  println(zippedStrings.zipped.exists(_.length != _))