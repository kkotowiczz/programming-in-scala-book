package com.github.kkotowiczz.chapter15

import com.github.kkotowiczz.chapter10.Element

class ExprFormatter {
  private val opGroups =
    Array(
      Set("|", "||"),
      Set("&", "&&"),
      Set("^"),
      Set("==", "!="),
      Set("<", "<=", ">", ">="),
      Set("+", "-"),
      Set("*", "%"),
    )

  private val precedence = {
    val assocs =
      for {
        i <- 0 until opGroups.length
        op <- opGroups(i)
      } yield op -> i
    assocs.toMap
  }
  private val unaryPrecedence = opGroups.length
  private val fractionPrecedence = -1


  private def format(e: Expr, enclPrec: Int): Element =
    e match {
      case Var(name) => Element.elem(name)

      case Number(num) =>
        def stripDot(s: String) = if (s.endsWith(".0")) s.substring(0, s.length - 2) else s
      Element.elem(stripDot(num.toString))


      case UnOp(op, arg) => Element.elem(op) beside format(arg, unaryPrecedence)

      case BinOp("/", left, right) =>
        val top = format(left, fractionPrecedence)
        val bot = format(right, fractionPrecedence)
        val line = Element.elem('-', top.width max bot.width, 1)
        val frac = top above line above bot
        if (enclPrec != fractionPrecedence) frac
        else Element.elem(" ") beside frac beside Element.elem(" ")

      case BinOp(op, left, right) =>
        val opPrec = precedence(op)
        val l = format(left, opPrec)
        val r = format(right, opPrec + 1)
        val oper = l beside Element.elem(" " + op + " ") beside r
        if (enclPrec <= opPrec) oper
        else Element.elem("(") beside oper beside Element.elem(")")
    }

  def format(e: Expr): Element = format(e, 0)
}
