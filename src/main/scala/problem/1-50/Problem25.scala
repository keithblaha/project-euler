package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Sequences._

class Problem25 extends EulerProblem {
  val fibs = fibonacciUntil(_.toString.length >= 1000)

  override def solution = fibs.size + 1
}

