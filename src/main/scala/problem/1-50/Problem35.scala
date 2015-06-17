package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Sequences._

class Problem35 extends EulerProblem {
  val primes = primesTo(1000000).toSet

  override def solution = {
    (for {
      n <- primes
      rotations = {
        val nStr = n.toString
        (0 until nStr.size).map(i => {
          val s = nStr.splitAt(i)
          (s._2 + s._1).toInt
        })
      }
      if rotations.forall(primes.contains)
    } yield n).size
  }
}

