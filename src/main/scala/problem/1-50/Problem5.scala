package com.keithblaha.euler.problem

import scala.collection.mutable.{Map => MutableMap}

import com.keithblaha.euler.util.Factor._
import com.keithblaha.euler.util.Sequences._

class Problem5 extends EulerProblem {
  val primes = primesTo(100)

  override def solution = {
    val maxPowers = MutableMap[Int, Int]()
    (2 to 20).foreach(i => {
      val primeFact = primeFactorization(i, primes)
      primeFact.keys.foreach(j => {
        maxPowers(j) = Math.max(primeFact.getOrElse(j, 0), maxPowers.getOrElse(j, 0))
      })
    })
    maxPowers.map(x => Math.pow(x._1, x._2)).product.toInt
  }
}

