package com.keithblaha.euler.problem

import scala.collection.mutable.Buffer

import com.keithblaha.euler.util.Factor._

class Problem58 extends EulerProblem {
  override def solution = {
    var n = 2
    var b = -1
    val primes = Buffer[Int](3, 5, 7)
    val nonPrimes = Buffer[Int](1, 9)
    while(primes.size.toDouble / (primes.size + nonPrimes.size) >= .1) {
      n += 2
      b = Math.max(nonPrimes.last, primes.last)
      (1 to 4).foreach(i => {
        val x = b + i * n
        if(isPrime(x)) primes += x
        else nonPrimes += x
      })
    }
    n + 1
  }
}

