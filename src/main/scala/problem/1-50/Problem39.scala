package com.keithblaha.euler.problem

class Problem39 extends EulerProblem {
  override def solution = {
    (for {
      p <- (3+4+5) to 1000
      s = (for {
        a <- 1 to p / 2
        b <- a to p / 2
        c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2))
        if c.isWhole && a + b + c == p
      } yield 1).size
    } yield (p, s)).maxBy(_._2)._1
  }
}

