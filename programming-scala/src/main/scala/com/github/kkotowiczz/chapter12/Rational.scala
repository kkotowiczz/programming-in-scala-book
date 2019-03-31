package com.github.kkotowiczz.chapter12

class Rational(n: Int, d: Int) extends Ordered[Rational]{
  require(d != 0)

  val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g
  override def toString = s"$numer/$denom"

  def this(n: Int) = this(n, 1)

  def + (i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def + (that: Rational): Rational =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def - (i: Int): Rational =
    new Rational(numer - i * denom, denom)

  def - (that: Rational): Rational =
    new Rational(
      numer * that.denom - that.numer * denom, denom * that.denom
    )

  def * (i: Int): Rational =
    new Rational(numer * i, denom)

  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def / (i: Int): Rational =
    new Rational(numer, denom * i)

  def / (that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  def lessThan(that: Rational): Boolean =
    this.numer * that.denom < that.numer * this.denom


  def max(that: Rational) = if(this.lessThan(that)) that else this

  override def compare(that: Rational): Int = (this.numer * that.denom) - (that.numer * this.denom)

  private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
}