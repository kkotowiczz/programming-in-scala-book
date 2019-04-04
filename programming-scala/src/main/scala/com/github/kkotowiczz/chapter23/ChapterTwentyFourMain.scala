package com.github.kkotowiczz.chapter23

object ChapterTwentyFourMain {

  val books: List[Book] =
    List(
      Book(
        "Structure and Interpretation of Computer Programs",
        "Abelson, Harold", "Sussman, Gerald J."
      ),
      Book(
        "Principles of Compiler Design",
        "Aho, Alfred", "Ullman, Jeffrey"
      ),
      Book(
        "Programming in Modula-2",
        "Wirth, Niklaus"
      ),
      Book(
        "Elements of ML Programming",
        "Ullman, Jeffrey"
      ),
      Book(
        "The Java Language Specification", "Gosling, James",
        "Joy, Bill", "Steele, Guy", "Bracha, Gilad"
      )
    )
  def main(args: Array[String]): Unit = {
    val lara = Person("Lara", false)
    val bob = Person("Bob", true)
    val julie = Person("Julie", false, bob, lara)
    val people = List(lara, bob, julie)

    val mothersList = people filter (p => !p.isMale) flatMap(p => p.children map (c => (p.name, c.name)))

    println(mothersList)

    val mothersListYield = for (p <- people;   if (!p.isMale); c <- p.children) yield (p.name, c.name)

    // for ( seq ) yield expr

    for (p <- people; n = p.name; if(n startsWith "To")) yield n

    val namesStartingWithTo = for {
      p <- people
      n = p.name
      if (n startsWith "To")
    } yield n

    println(namesStartingWithTo)

    val oneTwos = for {
      x <- List(1, 2)
      y <- List("one", "two")
    } yield (x, y)

    println(oneTwos)

    println(queens(8))

    val goslinsBooks = for {
      b <- books
      a <- b.authors
      if a startsWith("Gosling")
    } yield b.title

    println(goslinsBooks)

    val booksWithProgramInTitle = for(b <- books if (b.title indexOf "Program") >= 0) yield b.title
    println(booksWithProgramInTitle)

    val authorsWithTwoBooks = for {
      b1 <- books
      b2 <- books
      if (b1.title != b2.title)
      a1 <- b1.authors
      a2 <- b2.authors
      if a1 == a2
    } yield a1

    println(removeDuplicates(authorsWithTwoBooks))
    println(removeDuplicates2(authorsWithTwoBooks))
  }

  def queens(n: Int): List[List[(Int, Int)]] = {
    def placeQueens(k: Int): List[List[(Int, Int)]] =
      if (k == 0)
        List(List())
      else
        for {
        queens <- placeQueens(k - 1)
        column <- 1 to n
        queen = (k, column)
        if isSafe(queen, queens)
      } yield queen :: queens

    placeQueens(n)
  }

  def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) =
    queens forall (q => !inCheck(queen, q))

  def inCheck(q1: (Int, Int), q2: (Int, Int))  =
    q1._1 == q2._1 ||
    q1._2 == q2._2 ||
    (q1._1 - q2._1).abs == (q1._2 - q2._2).abs


  def removeDuplicates[A](xs: List[A]): List[A] = {
    if (xs.isEmpty) xs
    else
      xs.head :: removeDuplicates(
        xs.tail filter (x => x != xs.head)
      )
  }

  def removeDuplicates2[A](xs: List[A]): List[A] = {
    if (xs.isEmpty) xs
    else
      xs.head :: removeDuplicates2(
        for(x <- xs.tail if x != xs.head) yield x
      )
  }


}
