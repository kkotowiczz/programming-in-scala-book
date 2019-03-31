package com.github.kkotowiczz.chapter12

object ChapterTwelveMain {
  def main(args: Array[String]): Unit = {
    val frog = new Frog
    println(frog.philosophize())

    val phil: Philosophical = frog
    println(phil)

    val rect = new Rectangle(new Point(1, 1), new Point(10, 10))

    println(rect.width, rect.left, rect.right)

    val half = new Rational(1, 2)
    val third = new Rational(1, 3)

    println(half < third, half > third)

    val queue = new BasicIntQueue

    queue.put(10)
    queue.put(20)
    println(queue.get(), queue.get())

    val myQueue = new MyQueue

    myQueue.put(30)
    println(myQueue.get())

    // no need to define separate class
    val mySecondQueue = new BasicIntQueue with Doubling
    mySecondQueue.put(3111)
    println(mySecondQueue.get())

    val filterFirst = new BasicIntQueue with Incrementing with Filtering
    filterFirst.put(-1); filterFirst.put(0); filterFirst.put(1)
    println(filterFirst.get(), filterFirst.get())

    val incrementFirst = new BasicIntQueue with Filtering with Incrementing
    incrementFirst.put(-1); incrementFirst.put(0); incrementFirst(1)
    println(incrementFirst.get(), incrementFirst.get(), incrementFirst.get())
  }
}
