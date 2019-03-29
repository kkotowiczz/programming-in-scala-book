package com.github.kkotowiczz.chapter4

import com.github.kkotowiczz.chapter4.ChecksumAccumulator.calculate

object Summer {
  def main(args: Array[String]): Unit = {
    for(arg <- args)
      println(arg + " " + calculate(arg))
  }
}