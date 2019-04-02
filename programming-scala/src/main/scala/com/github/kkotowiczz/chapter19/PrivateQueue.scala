package com.github.kkotowiczz.chapter19

trait PrivateQueue[T] {
  def head: T
  def tail: PrivateQueue[T]
  def enqueue(x: T): PrivateQueue[T]
}

object PrivateQueue {
  def apply[T](xs: T*): PrivateQueue[T] = new PrivateQueueImpl[T](xs.toList, Nil)
}

class PrivateQueueImpl[T](private val leading: List[T], private val trailing: List[T]) extends PrivateQueue[T] {
  private def mirror =
    if(leading.isEmpty)
      new PrivateQueueImpl(trailing.reverse, Nil)
    else
      this

  def head = mirror.leading.head

  def tail = {
    val q = mirror
    new PrivateQueueImpl(q.leading.tail, q.trailing)
  }

  def enqueue(x: T) = new PrivateQueueImpl(leading, x :: trailing)
}
