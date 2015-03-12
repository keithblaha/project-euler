package com.keithblaha.euler.problem

class Problem4 extends EulerProblem {
  def isPalindrome(s: String): Boolean =  {
    if (s.length <= 1) true
    else if (s.head == s.last) isPalindrome(s.slice(1, s.length-1))
    else false
  }

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

