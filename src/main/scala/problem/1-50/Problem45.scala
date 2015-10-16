package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Sequences._

class Problem45 extends EulerProblem {
  val limit = 10000000000L
  val triangulars = triangularsTo(limit).toSet
  val pentagonals = pentagonalsTo(limit).toSet
  val hexagonals = hexagonalsTo(limit).toSet

  override def solution = triangulars.intersect(pentagonals).intersect(hexagonals).max
}

