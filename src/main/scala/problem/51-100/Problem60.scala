package com.keithblaha.euler.problem

import scala.collection.mutable.{Map => MutableMap, Set => MutableSet}

import com.keithblaha.euler.util.Factor
import com.keithblaha.euler.util.Sequences._

class Problem60 extends EulerProblem {
  val limit = 8500
  val primes = primesTo(limit).map(_.toInt)
  val primeSet = primes.toSet

  def isPrime(n: Int) = if (n <= limit) primeSet.contains(n) else Factor.isPrime(n)

  val seenPairs = MutableMap[Int,Boolean]()
  def isPair(a: Int, b: Int) = {
    val product = a * b
    if (seenPairs.contains(product)) seenPairs(product)
    else {
      val isPair = isPrime((a.toString + b.toString).toInt) && isPrime((b.toString + a.toString).toInt)
      seenPairs(product) = isPair
      isPair
    }
  }

  val seenGroups = MutableSet[Int]()
  def expandGroup(toExpand: Seq[Seq[Int]]) = for {
    group <- toExpand
    p <- primes
    product = group.product * p
    if !seenGroups.contains(product)
    markSeen = { seenGroups += product }
    if group.forall(isPair(_, p))
  } yield group :+ p

  override def solution = {
    val pairs = for {
      pair <- primes.combinations(2).toList
      if isPair(pair(0), pair(1))
    } yield pair

    val trips = expandGroup(pairs)
    val quads = expandGroup(trips)
    expandGroup(quads)(0).sum
  }
}

