package com.keithblaha.euler.problem

class Problem29 extends EulerProblem {
  override def solution = {
    (for {
      a <- 2.0 to 100 by 1
      b <- 2.0 to 100 by 1
    } yield Math.pow(a, b)).toSet.size
  }
}

