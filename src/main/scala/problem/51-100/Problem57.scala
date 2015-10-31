package com.keithblaha.euler.problem

class Problem57 extends EulerProblem {
  override def solution = Stream.iterate((BigInt(3),BigInt(2)), 1000)(x => (x._1 + 2 * x._2, x._1 + x._2)).filter(x => x._1.toString.length > x._2.toString.length).size
}

