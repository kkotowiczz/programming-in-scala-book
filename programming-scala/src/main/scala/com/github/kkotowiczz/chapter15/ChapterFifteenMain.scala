package com.github.kkotowiczz.chapter15

object ChapterFifteenMain {
  def main(args: Array[String]): Unit = {
    val v = Var("x")
    val op = BinOp("+", Number(1), v)

    println(v.name)
    println(op.left)

    println(op.right == Var("x"))

    val secondOp = op.copy(operator = "-")
    println(secondOp)

    println(PatternMatching.constantPattern("hello"))
    println(PatternMatching.constantPattern(5))
    println(PatternMatching.constantPattern(List(1, 2, 3)))
    println(PatternMatching.variablePattern(List(1, 2, 3)))

    println(PatternMatching.mathMatching)
    println(PatternMatching.mathMatching2)
    println(PatternMatching.mathMatching3)



    val f = new ExprFormatter
    val e1 = BinOp("*", BinOp("/", Number(1), Number(2)),
      BinOp("+", Var("x"), Number(1)))
    val e2 = BinOp("+", BinOp("/", Var("x"), Number(2)),
      BinOp("/", Number(1.5), Var("x")))
    val e3 = BinOp("/", e1, e2)
    def show(e: Expr) = println(f.format(e)+ "\n\n")
    for (e <- Array(e1, e2, e3)) show(e)

  }
}
