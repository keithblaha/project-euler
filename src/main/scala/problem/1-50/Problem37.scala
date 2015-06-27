package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Sequences._

class Problem37 extends EulerProblem {
  val primes = primesTo(1000000).toSet

  override def solution = {
    (for {
      n <- primes
      trunks = {
        val nStr = n.toString
        (1 until nStr.size).flatMap(i => {
          val s = nStr.splitAt(i)
          Seq(s._1, s._2).map(_.toInt)
        })
      }
      if trunks.forall(primes.contains)
    } yield n).filter(_ > 7).sum
  }
}

