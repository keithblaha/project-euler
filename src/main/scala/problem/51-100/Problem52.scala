package com.keithblaha.euler.problem

class Problem52 extends EulerProblem {
  def containSameDigits(s: Seq[Int]) = s.map(_.toString.groupBy(x=>x).mapValues(_.length)).distinct.size == 1

  override def solution = Stream.from(100000).find(x => containSameDigits((1 to 6).map(_ * x))).get
}

