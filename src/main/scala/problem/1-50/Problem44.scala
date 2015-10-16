package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Sequences._

class Problem44 extends EulerProblem {
  val pentagonals = pentagonalsTo(10000000)
  val pentagonalsSet = pentagonals.toSet

  override def solution = (for {
    k <- pentagonals
    j <- pentagonals.filter(_ < k)
    if pentagonalsSet.contains(k + j) && pentagonalsSet.contains(k - j)
  } yield k - j).head
}

