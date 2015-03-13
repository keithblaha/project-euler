package com.keithblaha.euler.problem

class Problem16 extends EulerProblem {
  override def solution = BigInt(2).pow(1000).toString().map(_.asDigit).sum
}

