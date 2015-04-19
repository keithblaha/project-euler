package com.keithblaha.euler.problem

import scala.annotation.tailrec
import scala.collection.mutable.LinkedHashSet

class Problem26 extends EulerProblem {
  @tailrec private def recurringCycleLengthForUnitFraction(denominator: Int, l: LinkedHashSet[Int] = LinkedHashSet()): Int = {
    val v = BigInt(10).modPow(l.size, denominator).toInt

    if(v == 0) 0
    else if(l.contains(v)) l.size - l.toList.indexOf(v)
    else recurringCycleLengthForUnitFraction(denominator, l += v)
  }

  override def solution = {
    (1 until 1000).map(x => (x, recurringCycleLengthForUnitFraction(x))).maxBy(x => x._2)._1
  }
}

