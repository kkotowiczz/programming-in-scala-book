package com.github.kkotowiczz.chapter15
import math.{E, Pi}

object PatternMatching {
  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e // double negation
    case BinOp("+", e, Number(0)) => e // adding zero
    case BinOp("*", e, Number(1)) => e // multiplying by one
    case _ => expr
  }

  def defaultCase(expr: Expr)= expr match {
    case BinOp("+", UnOp("+", Number(1)), UnOp("-", Number(0))) => println(expr + " is a binary operation")
    case _ => println("Not binary op")
  }

  def constantPattern(x: Any) = x match  {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "Empty list"
    case _ => "something else"
  }

  def variablePattern(x: Any) = x match {
    case 0 => "zero"
    case somethingElse => "not zero: " + somethingElse
  }

  def mathMatching = E match {
    case Pi => "Strange math? Pi = " + Pi
    case _ => "OK"
  }
  // compiler binds it to lowercase variable
  def mathMatching2 = E match {
    case pi => "Strange math? Pi = " + pi
  }

  val pipi = Pi

  def mathMatching3 = E match {
    case `pipi` => "Strange math? Pi = " + pipi
    case _ => "OK"
  }

  def deepConstructorMatch(op: Expr) = op match {
    case BinOp("+", e, Number(0)) => println("a deep match")
    case _ => "try again"
  }

  def sequencePattern(seq: Traversable[Int]) = seq match {
    case List(0, _, _) => println("found it")
    case _ => println("not found")
  }

  def unspecifiedLengthSeqPattern(seq: Traversable[Int]) = seq match {
    case List(0, _*) => println("found it")
    case _ => println("not found")
  }

  def tuplePattern(expr: Any) =
    expr match {
      case (a, b, c) => println("matched " + a + b + c)
      case _ => println("not matched")
    }

  def typedMatch(x: Any) = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }

  def isIntIntMap(x: Any) = x match {
    // this would not work, because generics use erasure model, no information about type is maintained at runtime
    case m: Map[Int, Int] => true
    case _ => false
  }

  // the only exception is array type, they are handled differently
  def isStringArray(x: Any) = x match {
    case a: Array[String] => "yes"
    case _ => "no"
  }

  def variableBindingPattern(x: Any): Expr = x match {
    case UnOp("abs", e @ UnOp("abs", _)) => e
    case _ => Var("x")
  }

  def patternGuarding(x: Any): Expr = x match {
    case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
  }

  def sealedClass(e: Expr): String = e match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
    case _ => throw new RuntimeException // should not happen
  }
  def sealedClass2(e: Expr): String = (e: @unchecked) match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }

  val myTuple = (123, "abc")

  val (number, string) = myTuple

  val exp = new BinOp("*", Number(5), Number(1))

  val BinOp(op, left, right) = exp

  val withDefault: Option[Int] => Int = {
    case Some(x) => x
    case None => 0
  }

  // warning, match is not exhaustive
  val second: List[Int] => Int = {
    case x :: y  :: _ => y
  }

  val correctSecond: PartialFunction[List[Int], Int] = {
    case x :: y :: _ => y
  }
}
