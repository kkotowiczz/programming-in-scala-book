class Rational(n: Int, d: Int) {
  require(d != 0)
  val numer: Int = n / g
  val denom: Int = d / g
  val g = gcd(n.abs, d.abs)
  override def toString = s"$numer/$denom"

  def this(Int: n) = this(n, 1)

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
  

  def max(that: Rational) = if(this.lessThan(that) that else this)

  private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
}