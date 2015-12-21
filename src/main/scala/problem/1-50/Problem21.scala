package com.keithblaha.euler.problem

import scala.collection.mutable.{Set => MutableSet}

import com.keithblaha.euler.util.Factor._
import com.keithblaha.euler.util.Sequences._

class Problem21 extends EulerProblem {
  val primes = primesTo(1000)

  def amicableWith(n: Int) = {
    val d = sumOfProperFactors(n, primes)
    if(sumOfProperFactors(d, primes) == n && d != n) d
    else -1
  }

  override def solution = {
    val alreadyCounted = MutableSet[Int]()
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

