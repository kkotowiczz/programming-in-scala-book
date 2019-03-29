package com.github.kkotowiczz.chapter10

abstract class Element {
  def contents: Array[String]
  val height = contents.length
  val width = if (height == 0) 0 else contents(0).length
}
