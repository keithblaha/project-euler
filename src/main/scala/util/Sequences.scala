package com.keithblaha.euler.util

import scala.collection.mutable.Buffer

object Sequences {
  def primesTo(limit: Int) = {
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

  def fibonacciWhile(condition: BigInt => Boolean) = {
    lazy val fibs: Stream[BigInt] = BigInt(1) #:: BigInt(1) #:: fibs.zip(fibs.tail).map{n => n._1 + n._2}
    fibs.takeWhile(condition)
  }
}

