package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Factor._
import com.keithblaha.euler.util.Sequences._
import com.keithblaha.euler.util.Sum._

class Problem12 extends EulerProblem {
  val primes = primesTo(1000)

  override def solution = {
    Stream.from(1).map(x => (x, sumTo(x))).find(x => numFactors(x._2, primes) > 500).get._2
  }
}

