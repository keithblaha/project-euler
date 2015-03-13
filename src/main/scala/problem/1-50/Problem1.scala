package com.keithblaha.euler.problem

class Problem1 extends EulerProblem {
  override def solution = (3 until 1000 by 3).filterNot(_ % 5 == 0).sum + (5 until 1000 by 5).sum
}

