package com.keithblaha.euler.problem

import scala.annotation.tailrec

import com.keithblaha.euler.util.Combinatorics._

class Problem24 extends EulerProblem {
  val target = 1000000 - 1 // my nthLexPermutation function is 0-indexed
  val digits = Seq(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

  @tailrec private def nthLexPermutation(n: Int, d: Seq[Int], a: String = ""): String = {
    if(d.size == 1) a + d(0)
    else {
      val s = factorial(d.size - 1)
      val i = (n / s).toInt
      val r = d.take(i) ++ d.drop(i + 1)
      nthLexPermutation((n % s).toInt, r, a + d(i))
    }
  }

  override def solution = nthLexPermutation(target, digits)
}

