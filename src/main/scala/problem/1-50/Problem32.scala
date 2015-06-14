package com.keithblaha.euler.problem

class Problem32 extends EulerProblem {
  override def solution = {
    (for {
      s <- "123456789".permutations
      p <- Seq((1, 5), (2, 5))
      n = p._1
      m = p._2
      multiplicand = s.substring(0, n).toInt
      multiplier = s.substring(n, m).toInt
      product = multiplicand * multiplier
      if product == s.substring(m, 9).toInt
    } yield product).toSet.sum
  }
}

