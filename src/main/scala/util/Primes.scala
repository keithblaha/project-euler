package com.keithblaha.euler.util

import scala.collection.mutable.Buffer

object Primes {
  def generatePrimesTo(limit: Int) = {
    // Sieve of Eratosthenes
    val isPrimeMap = scala.collection.mutable.Map[Int, Boolean]()
    val nums = (2 to limit)
    val primes = Buffer[Int]()

    nums.foreach(n => {
      if(isPrimeMap.getOrElse(n, true)) {
        primes += n
        for(composite <- n*2 to limit by n) {
          isPrimeMap(composite) = false
        }
      }
    })

    primes
  }
}

