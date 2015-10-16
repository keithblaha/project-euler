package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Sequences._

class Problem42 extends EulerProblem {
  val words = resource.mkString.replace("\"", "").split(',')
  val triangulars = triangularsTo(1000).toSet
  val charOffset = 'A'.toInt - 1

  override def solution = words.map(_.map(_.toInt - charOffset).sum.toLong).filter(triangulars.contains).size
}

