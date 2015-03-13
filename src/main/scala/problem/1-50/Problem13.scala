package com.keithblaha.euler.problem

class Problem13 extends EulerProblem {
  val bigNums = resource.getLines.map(BigInt(_))

  override def solution = bigNums.sum.toString.slice(0,10).toLong
}

