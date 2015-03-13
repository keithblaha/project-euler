package com.keithblaha.euler.problem

class Problem22 extends EulerProblem {
  val charOffset = 'A'.toInt - 1
  val names = resource.getLines.toSeq.head.stripPrefix("\"").stripSuffix("\"")
                .split("\",\"").sorted

  override def solution = {
    var n = 0
    names.map(name => {
      n += 1
      name.map(_.toInt - charOffset).sum * n
    }).sum
  }
}

