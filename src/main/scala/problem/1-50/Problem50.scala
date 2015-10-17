package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Sequences._

class Problem50 extends EulerProblem {
  val primes = primesTo(1000000)

  override def solution = (for {
    i <- 1 to 5
    j <- 540 to 545
    s = primes.drop(i).take(j).sum
    if primes.contains(s)
  } yield s).max
}

