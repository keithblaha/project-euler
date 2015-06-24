package com.keithblaha.euler.problem

import com.keithblaha.euler.util.String._

class Problem36 extends EulerProblem {
  override def solution = {
    (for {
      n <- (1 until 1000000 by 2)
      if isPalindrome(n.toString) && isPalindrome(n.toBinaryString)
    } yield n).sum
  }
}

