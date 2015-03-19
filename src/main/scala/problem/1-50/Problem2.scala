package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Sequences._

class Problem2 extends EulerProblem {
  val fibs = fibonacciUntil(_ > 4000000)

  override def solution = fibs.filter(_ % 2 == 0).sum
}

