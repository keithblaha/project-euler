package com.keithblaha.euler.util

import scala.collection.mutable.{Buffer, Map => MutableMap}

object Sequences {
  def primesTo(limit: Int) = {
    // use optimized Sieve of Eratosthenes
    val isPrimeMap = MutableMap[Int, Boolean]()
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

  def triangularsTo(limit: Long) = {
    Stream.iterate((1L,1L))(x=>(x._1+1,x._1+x._2+1)).takeWhile(_._2 <= limit).map(_._2).toList
  }

  def pentagonalsTo(limit: Long) = {
    Stream.iterate((1L,1L))(x => (x._1 + 1, (x._1 + 1) * (3*(x._1 + 1) - 1) / 2)).takeWhile(_._2 <= limit).map(_._2).toList
  }

  def hexagonalsTo(limit: Long) = {
    Stream.iterate((1L,1L))(x => (x._1 + 1, (x._1 + 1) * (2*(x._1 + 1) - 1))).takeWhile(_._2 <= limit).map(_._2).toList
  }
}

