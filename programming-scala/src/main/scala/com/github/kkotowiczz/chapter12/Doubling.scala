package com.github.kkotowiczz.chapter12

trait Doubling extends IntQueue {
  // super.put will work, because super in trait is bounded dynamically
  // abstract override is must in traits, it means that the trait must be mixed into some class
  abstract override def put(x: Int): Unit = { super.put(2 * x) }
}
