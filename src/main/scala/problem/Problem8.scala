package com.keithblaha.euler.problem

class Problem8 extends EulerProblem {
  override def solution = {
    val longNum = resource.getLines.mkString

    def largestAdjacentProduct(n: Int, s: String) = {
      var max = -1L
      for(x <- 0 to s.length - n) {
        val product = s.slice(x, x + n).map(_.asDigit.toLong).product
        if(product > max) max = product
      }
      max
    }

    largestAdjacentProduct(13, longNum)
  }
}

