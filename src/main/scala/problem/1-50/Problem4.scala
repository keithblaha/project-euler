package com.keithblaha.euler.problem

import com.keithblaha.euler.util.String._

class Problem4 extends EulerProblem {
  override def solution = {
    var max = -1
    (100 until 1000).foreach(x => {
      (100 until 1000).foreach(y => {
        val n = x * y
        if(isPalindrome(n.toString) && n > max) max = n
      })
    })
    max
  }
}

