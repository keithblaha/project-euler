package com.keithblaha.euler.problem

import scala.util.control.Breaks._

import com.keithblaha.euler.util.Factor._
import com.keithblaha.euler.util.Primes._
import com.keithblaha.euler.util.Sum._

class Problem12 extends EulerProblem {
  val primes = generatePrimesTo(1000)

  override def solution = {
    var n = 1
    var nth = 1
    breakable {
      while(true) {
        nth = sumTo(n)
        if(numFactors(nth, primes) > 500) break
        else n += 1
      }
    }
    nth
  }
}

