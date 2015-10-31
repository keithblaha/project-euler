package com.keithblaha.euler.problem

import com.keithblaha.euler.util.String._

class Problem55 extends EulerProblem {
  def isLychrel(n: BigInt) = Stream.iterate(n, 51)(x => x + BigInt(x.toString.reverse)).drop(1).find(x => isPalindrome(x.toString)).isEmpty

  override def solution = (BigInt(1) until 10000).filter(isLychrel(_)).size
}

