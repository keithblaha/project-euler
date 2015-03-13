package com.keithblaha.euler.util

import scala.collection.mutable.Buffer

object Factor {
  def primeFactorization(n: Int, primes: Traversable[Int]) = {
    var num = n
    val primeFactors = Buffer[Int]()
    for(i <- primes.withFilter(_ <= n)) {
      while(num % i == 0) {
        primeFactors += i
        num /= i
      }
    }
    primeFactors.groupBy(x => x).map(x => (x._1, x._2.size))
  }

  def numFactors(n: Int, primes: Traversable[Int]) = {
    primeFactorization(n, primes).map(_._2 + 1).product
  }

  def sumOfDivisors(n: Int, primes: Traversable[Int]) = {
    primeFactorization(n, primes).map(x => {
      (0 to x._2).map(Math.pow(x._1,_)).sum
    }).product.toInt
  }

  def sumOfProperDivisors(n: Int, primes: Traversable[Int]) = {
    sumOfDivisors(n, primes) - n
  }
}

