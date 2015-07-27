package com.keithblaha.euler.problem

class Problem38 extends EulerProblem {
  override def solution = {
    (for {
      s <- "987654321".permutations
      if {
        val b = s.substring(0, 4).toInt
        s == (1 to 2).map(x => (x * b).toString).reduce(_ + _)
      }
    } yield s).next.toInt
  }
}

