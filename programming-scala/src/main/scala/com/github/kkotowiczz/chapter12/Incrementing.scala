package com.github.kkotowiczz.chapter12

trait Incrementing extends IntQueue {
  abstract override def put(x: Int): Unit = { super.put(x + 1)}
}
