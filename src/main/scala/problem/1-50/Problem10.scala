package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Sequences._

class Problem10 extends EulerProblem {
  val primes = primesTo(2000000)

  override def solution = primes.map(_.toLong).sum
}

