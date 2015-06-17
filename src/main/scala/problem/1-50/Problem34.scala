package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Combinatorics._

class Problem34 extends EulerProblem {
  override def solution = {
    (for {
      n <- BigInt(10) until BigInt(100000)
      if n == n.toString.map(x => factorial(x.asDigit)).sum
    } yield n).sum
  }
}

