package com.keithblaha.euler.problem

class Problem32 extends EulerProblem {
  override def solution = {
    (for {
      s <- "123456789".permutations
      (n, m) <- Seq((1, 5), (2, 5))
      multiplier = s.substring(0, n).toInt
      multiplicand = s.substring(n, m).toInt
      product = multiplier * multiplicand
      if product == s.substring(m, 9).toInt
    } yield product).toSet.sum
  }
}

