package com.keithblaha.euler.problem

import scala.collection.immutable.SortedSet

import com.keithblaha.euler.util.Sequences._

class Problem51 extends EulerProblem {
  val primes = SortedSet[Int]() ++ primesTo(1000000)

  override def solution = (for {
    p <- primes.filter(x => x > 120000 && x < 125000)
    s = p.toString
    n <- 2 until s.length
    i <- (0 to s.length).combinations(n)
    r = ('0' to '9').map(c => {
          s.zipWithIndex.map(z => if(i.contains(z._2)) c else z._1).mkString
        }).map(_.toInt).filter(_.toString.length == s.length).filter(primes.contains)
    if r.length >= 8
  } yield r).flatten.min
}

