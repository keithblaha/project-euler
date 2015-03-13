package com.keithblaha.euler.problem

import scala.annotation.tailrec

class Problem14 extends EulerProblem {
  // could make a lot faster with memoization
  @tailrec private def collatzLen(n: Long, c: Int = 0): Int = {
    if(n == 1) c+1
    else if(n % 2 == 0) collatzLen(n / 2, c+1)
    else collatzLen(3 * n + 1, c+1)
  }

  override def solution = {
    var max = (-1, -1)
    (1 until 1000000).foreach(n => {
      val l = collatzLen(n)
      if(l > max._2) max = (n,l)
    })
    max._1
  }
}

