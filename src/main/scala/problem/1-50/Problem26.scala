package com.keithblaha.euler.problem

import scala.collection.mutable.LinkedHashSet
import scala.util.control.Breaks._

class Problem26 extends EulerProblem {
  def recurringCycleLengthForUnitFraction(denominator: Int): Int = {
    val s = LinkedHashSet[Int]()
    var t = -1

    breakable {
      for(x <- 0 until denominator) {
        val v = BigInt(10).modPow(x, denominator).toInt
        if(v == 0) return 0
        else if(s.contains(v)) {
          t = v;
          break;
        }
        else s += v
      }
    }

    var i = s.toList.indexOf(t)
    if(i > 0) s.size - i
    else s.size
  }

  override def solution = {
    (1 until 1000).map(x => (x, recurringCycleLengthForUnitFraction(x))).maxBy(x => x._2)._1
  }
}

