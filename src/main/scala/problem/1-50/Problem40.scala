package com.keithblaha.euler.problem

class Problem40 extends EulerProblem {
  def sizeForLength(l: Int) = l * 9 * Math.pow(10, l-1)

  override def solution = (for {
    n <- (0 to 6).map(x => Math.pow(10, x).toInt)
    l = Stream.from(1).find(sizeForLength(_) >= n).get
    s = (0 to l-1).map(sizeForLength(_)).sum.toInt
    i = (n - s) % l - (if(l == 1) 0 else 1)
    x = (n - s) / l + (if(l == 1) 0 else Math.pow(10, l-1))
    d = x.toInt.toString.charAt(i).asDigit
  } yield d).product
}

