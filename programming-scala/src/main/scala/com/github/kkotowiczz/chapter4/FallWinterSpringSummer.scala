package com.github.kkotowiczz.chapter4

import com.github.kkotowiczz.chapter4.ChecksumAccumulator.calculate


object FallWinterSpringSummer extends App {
  for (season <- List("fall", "winter", "spring"))
    println(season + ": " + calculate(season))
}
