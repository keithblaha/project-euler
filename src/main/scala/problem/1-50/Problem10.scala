package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Primes._

class Problem10 extends EulerProblem {
  val primes = generatePrimesTo(2000000)

  override def solution = primes.map(_.toLong).sum
}

