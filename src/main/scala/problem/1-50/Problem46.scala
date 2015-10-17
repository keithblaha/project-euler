package com.keithblaha.euler.problem

import scala.collection.immutable.SortedSet

import com.keithblaha.euler.util.Sequences._

class Problem46 extends EulerProblem {
  val limit = 6000
  val primes = SortedSet[Int]() ++ primesTo(limit)
  val oddComposites = Stream.from(9, 2).takeWhile(_ <= limit).filterNot(primes.contains(_))

  def satisfiesGoldbach(n: Int) = (for {
    p <- primes
    s <- (1 to Math.sqrt(n-p).toInt)
    if p + 2 * s * s == n
  } yield 1).sum > 0

  override def solution = oddComposites.find(!satisfiesGoldbach(_)).get
}

