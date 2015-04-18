package com.keithblaha.euler.util

import scala.annotation.tailrec

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

  def factors(n: Int, primes: Traversable[Int]) = primeFactorizationPermutations(primeFactorization(n, primes))

  def properFactors(n: Int, primes: Traversable[Int]) = factors(n, primes).dropRight(1)

  def numFactors(n: Int, primes: Traversable[Int]) = numFactorsFromPrimeFactorization(primeFactorization(n, primes))

  def sumOfFactors(n: Int, primes: Traversable[Int]) = {
    primeFactorization(n, primes).map(x => {
      (0 to x._2).map(Math.pow(x._1,_)).sum
    }).product.toInt
  }

  def sumOfProperFactors(n: Int, primes: Traversable[Int]) = sumOfFactors(n, primes) - n

  def areRelativelyPrime(n: Int, m: Int, primes: Traversable[Int]) = {
    n != m && properFactors(n, primes).intersect(properFactors(m, primes)).size == 1
  }

  private def numFactorsFromPrimeFactorization(m: Map[Int, Int]) = m.map(_._2 + 1).product

  private def primeFactorizationPermutations(m: Map[Int, Int]) = {
    val primeFactors = m.keys.toList
    val expCombs = exponentCombinations(m.map(x => (0 to x._2).toList).toList)
    expCombs.map(c => {
      c.zipWithIndex.map(x => Math.pow(primeFactors(x._2), x._1)).product.toInt
    })
  }

  private def exponentCombinations(ll: List[List[Int]]): List[List[Int]] = {
    ll match {
      case first :: second :: Nil => first.map(f => second.map(s => List(f, s))).flatten
      case first :: second :: tail => exponentCombinations(second :: tail).map(l => first.map(f => f :: l)).flatten
      case _ => ll.flatten.map(List(_))
    }
  }
}

