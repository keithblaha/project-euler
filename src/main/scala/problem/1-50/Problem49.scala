package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Sequences._

class Problem49 extends EulerProblem {
  val primes = primesTo(9999).filter(_ > 1000)

  override def solution = (for {
    p <- primes
    o = p.toString.permutations.map(_.toInt).filter(primes.contains(_)).toList
    if o.size >= 3
    s = o.sorted
    c = s.combinations(3).find(x => x(1) - x(0) == x(2) - x(1))
    if c.isDefined && c.get(0) != 1487
  } yield c.get.toList.mkString).distinct.head
}

