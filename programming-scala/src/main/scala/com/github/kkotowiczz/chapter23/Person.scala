package com.github.kkotowiczz.chapter23

case class Person(name: String, isMale: Boolean, children: Person*)
case class Book(title: String, authors: String*)
