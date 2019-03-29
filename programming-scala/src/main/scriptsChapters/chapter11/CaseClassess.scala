class Dollars(val amount: Int) extends AnyVal {
  override def toString() = "$" + amount
}

class SwissFrancs(val amount: Int) extends AnyVal {
  override def toString() = amount + " CHF"
}

class Anchor(val value: String) extends AnyVal
class Text(val value: String) extends AnyVal
class Html(val value: String) extends AnyVal
class Style(val value: String) extends AnyVal

object CaseClassess {
  def title(text: Text, anchor: Anchor, style: Style): Html =
    new Html(
      s"<a id='${anchor.value}'>" +
              s"<h1 class='${style.value}'>" +
                text.value +
              s"</h1></a>"
    )
}



