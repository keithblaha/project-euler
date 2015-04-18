package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Sequences._

class Problem27 extends EulerProblem {
  val primes = primesTo(10000).toSet

  def numberConsecutivePrimesForQuadratic(a: Int, b: Int): Int = {
    Stream.from(0).map(n => n * n + a * n + b).takeWhile(primes.contains).size
  }

  override def solution = {
    val consecutivePrimes = for {
      a <- -999 to 999
      b <- (-999 to 999).filter(primes.contains)
    } yield (a, b, numberConsecutivePrimesForQuadratic(a, b))

    val max = consecutivePrimes.maxBy(x => x._3)
    max._1 * max._2
  }
}

