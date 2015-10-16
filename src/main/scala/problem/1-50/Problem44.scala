package com.keithblaha.euler.problem

class Problem44 extends EulerProblem {
  val pentagonals = Stream.iterate((1,1))(x => (x._1 + 1, (x._1 + 1) * (3*(x._1 + 1) - 1) / 2)).takeWhile(_._2 <= 10000000).map(_._2).toList
  val pentagonalsSet = pentagonals.toSet

  override def solution = (for {
    k <- pentagonals
    j <- pentagonals.filter(_ < k)
    if pentagonalsSet.contains(k + j) && pentagonalsSet.contains(k - j)
  } yield k - j).head
}

