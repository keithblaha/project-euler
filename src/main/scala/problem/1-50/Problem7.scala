package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Primes._

class Problem7 extends EulerProblem {
  val primes = generatePrimesTo(1000000).toSeq.sorted

  override def solution = primes(10000)
}

