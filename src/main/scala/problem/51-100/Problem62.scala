package com.keithblaha.euler.problem

class Problem62 extends EulerProblem {
  val limit = 10000
  val cubes = (1L to limit).map(x => x * x * x)
  val signatures = cubes.map { cube =>
    (
      cube.toString.groupBy(_.toChar).mapValues(_.length),
      cube
    )
  }.groupBy(_._1).mapValues(_.map(_._2))

  override def solution = signatures.find(_._2.size == 5).get._2.min
}

