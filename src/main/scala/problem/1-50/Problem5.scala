package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Factor._
import com.keithblaha.euler.util.Primes._

class Problem5 extends EulerProblem {
  val primes = generatePrimesTo(100)

  override def solution = {
    val maxPowers = scala.collection.mutable.Map[Int, Int]()
    (2 to 20).foreach(i => {
      val primeFact = primeFactorization(i, primes)
      primeFact.keys.foreach(j => {
        maxPowers(j) = Math.max(primeFact.getOrElse(j, 0), maxPowers.getOrElse(j, 0))
      })
    })
    maxPowers.map(x=>Math.pow(x._1, x._2)).product.toInt
  }
}

