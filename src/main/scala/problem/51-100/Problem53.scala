package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Combinatorics._

class Problem53 extends EulerProblem {
  override def solution = (for {
    n <- 1 to 100
    k <- 1 to n
    c = choose(n, k)
    if c > 1000000
  } yield c).size
}


