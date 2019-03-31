package com.github.kkotowiczz.chapter12

class Frog extends Animal with Philosophical with HasLegs {
  override def toString: String = "green"

  override def philosophize(): Unit = {
    println("It ain't easy being " + toString + "!")
  }
}
