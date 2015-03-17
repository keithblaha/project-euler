package com.keithblaha.euler.util

import scala.collection.mutable.Buffer

object Primes {
  def generatePrimesTo(limit: Int) = {
    // use optimized Sieve of Eratosthenes
    val isPrimeMap = scala.collection.mutable.Map[Int, Boolean]()
    val primes = Buffer[Int](2)

    // only need to look at odds
    (3 to limit by 2).foreach(n => {
      if(isPrimeMap.getOrElse(n, true)) {
        primes += n

        (n*2 to limit by n).foreach(c => {
          isPrimeMap(c) = false
        })
      }
    })

    primes
  }
}

