package com.github.kkotowiczz.chapter16

class Lists {
  val fruit = List("apples", "oranges", "pears")
  val nums = List(1, 2, 3, 4)

  val diag3 = List (
    List(1, 0, 0),
    List(0, 1, 0),
    List(0, 0, 1)
  )
  val empty = List()


  val fruit2: List[String] = List("apples", "oranges", "pears")
  val nums2: List[Int] = List(1, 2, 3, 4)

  val diag32: List[List[Int]] = List (
    List(1, 0, 0),
    List(0, 1, 0),
    List(0, 0, 1)
  )

  val empty2: List[Nothing] = List()

  val fruit3 = "apples" :: ("oranges" :: ("pears" :: Nil))

  val nums3 = 1 :: (2 :: (3 :: (4 :: Nil)))
  val diag33 = (1 :: (0 :: (0 :: Nil))) ::
    (0 :: (1 :: (0 :: Nil))) ::
    (0 :: (0 :: (1 :: Nil))) :: Nil
  val empty3 = Nil

  val nums4 = 1 :: 2 :: 3 :: 4 :: Nil

  def isort(xs: List[Int]): List[Int] =
    if(xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))

  def insert(x: Int, xs: List[Int]): List[Int] =
    if(xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)

  def isortPattern(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case x :: xs1 => insertPattern(x, isort(xs1))
  }

  def insertPattern(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys =>
      if (x <= y) x :: xs
      else y :: insert(x, ys)
  }

  val l1 = List(1, 2) ::: List(3, 4, 5)

  def append[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case x :: xs1 => x :: append(xs1, ys)
  }

  val abcde = List('a', 'b', 'c', 'd', 'e')

  abcde.last
  abcde.init


  abcde.reverse

  List(List(1, 2), List(3), List(), List(4, 5)).flatten

  abcde.indices zip abcde

  abcde.zipWithIndex
}
