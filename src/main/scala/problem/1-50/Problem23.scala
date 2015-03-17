package com.keithblaha.euler.problem

import scala.util.control.Breaks._

import com.keithblaha.euler.util.Factor._
import com.keithblaha.euler.util.Primes._

class Problem23 extends EulerProblem {
  val limit = 28123
  val nums = (1 to limit)
  val primes = generatePrimesTo(limit)
  val abundantNumbers = nums.filter(n => sumOfProperDivisors(n, primes) > n)

  val sumsOfAbundants = scala.collection.mutable.Set[Int]()
  for(i <- 0 until abundantNumbers.size) {
    breakable {
      for(j <- i until abundantNumbers.size) {
        val s = abundantNumbers(i) + abundantNumbers(j)
        if(s <= limit) sumsOfAbundants += s
        else break
      }
    }
  }

  override def solution = nums.filterNot(sumsOfAbundants.contains(_)).sum
}

