package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Factor._

class Problem41 extends EulerProblem {
  // 9 and 8 digit pandigitals eliminated by divisibility rule of 3
  override def solution = "7654321".permutations.map(_.toInt).find(isPrime).get
}

