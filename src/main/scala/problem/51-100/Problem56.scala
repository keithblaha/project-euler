package com.keithblaha.euler.problem

class Problem56 extends EulerProblem {
  override def solution = (for {
    a <- BigInt(1) to 99
    b <- 1 to 99
    x = a.pow(b).toString.map(_.asDigit).sum
  } yield x).max
}

