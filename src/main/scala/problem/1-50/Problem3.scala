package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Sequences._

class Problem3 extends EulerProblem {
  var n = 600851475143L
  val primes = primesTo(Math.sqrt(n).toInt)

  override def solution = primes.filter(n % _ == 0).max
}

