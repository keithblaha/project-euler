package com.keithblaha.euler.problem

import scala.collection.mutable.SortedSet
import scala.util.control.Breaks._

class Problem26 extends EulerProblem {
  def recurringCycleLengthForUnitFraction(denominator: Int) = {
    val s = SortedSet[Int]()
    var t = -1

    breakable {
      for(x <- 0 to denominator) {
        val v = BigInt(10).modPow(x, denominator).toInt
        if(s.contains(v)) {
          t = v;
          break;
        }
        else s += v
      }
    }

    var i = s.toList.indexOf(t)
    if(i > 0) s.size - i + 1
    else s.size
  }

  override def solution = {
    (1 until 1000).map(x => (x, recurringCycleLengthForUnitFraction(x))).maxBy(x => x._2)._1
  }
}

