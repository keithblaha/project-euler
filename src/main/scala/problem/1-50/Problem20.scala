package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Combinatorics._

class Problem20 extends EulerProblem {
  override def solution = factorial(100).toString.map(_.asDigit).sum
}

