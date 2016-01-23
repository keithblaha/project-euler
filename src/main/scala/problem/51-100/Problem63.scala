package com.keithblaha.euler.problem

class Problem63 extends EulerProblem {
  val limit = 21

  override def solution = (for {
    l <- 1 to limit
    min = BigDecimal(10).pow(l - 1)
    max = BigDecimal(10).pow(l) - 1
    n <- 1 to limit
    v = BigDecimal(n).pow(l)
    if v >= min && v <= max
  } yield v).size
}

