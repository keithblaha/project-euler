package com.keithblaha.euler.problem

class Problem30 extends EulerProblem {
  override def solution = (for {
    n <- 2 to Math.pow(9, 5).toInt * 6
    if n.toString.map(x => Math.pow(x.asDigit, 5)).sum == n
  } yield n).sum
}

