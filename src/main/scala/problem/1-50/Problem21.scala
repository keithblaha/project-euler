package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Factor._
import com.keithblaha.euler.util.Primes._

class Problem21 extends EulerProblem {
  val primes = generatePrimesTo(1000)

  def amicableWith(n: Int) = {
    val d = sumOfProperDivisors(n, primes)
    if(sumOfProperDivisors(d, primes) == n && d != n) d
    else -1
  }

  override def solution = {
    val alreadyCounted = scala.collection.mutable.Set[Int]()
    var sum = 0
    (2 until 10000).foreach(n => {
      if(!alreadyCounted.exists(_ == n)) {
        val a = amicableWith(n)
        if(a > -1) {
          sum += (n + a)
          alreadyCounted += a
        }
      }
    })
    sum
  }
}

