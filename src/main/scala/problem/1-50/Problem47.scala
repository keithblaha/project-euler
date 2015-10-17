package com.keithblaha.euler.problem

import scala.collection.immutable.SortedSet

import com.keithblaha.euler.util.Factor._
import com.keithblaha.euler.util.Sequences._

class Problem47 extends EulerProblem {
  val limit = 135000
  val primes = SortedSet[Int]() ++ primesTo(limit)

  override def solution = (for {
    n1 <- (134000 to limit).filterNot(primes.contains(_))
    if !primes.contains(n1+1) && !primes.contains(n1+2) && !primes.contains(n1+3)
    f1 = primeFactorization(n1, primes)
    if f1.size == 4
    n2 = n1+1
    f2 = primeFactorization(n2, primes)
    if f2.size == 4
    n3 = n1+2
    f3 = primeFactorization(n3, primes)
    if f3.size == 4
    n4 = n1+3
    f4 = primeFactorization(n4, primes)
    if f4.size == 4
  } yield n1).head
}

