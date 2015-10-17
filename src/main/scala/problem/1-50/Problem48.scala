package com.keithblaha.euler.problem

class Problem48 extends EulerProblem {
  override def solution = (1 to 1000).map(n => BigInt(n).pow(n)).sum.toString.takeRight(10)
}

