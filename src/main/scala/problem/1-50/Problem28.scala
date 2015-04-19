package com.keithblaha.euler.problem

class Problem28 extends EulerProblem {
  override def solution = {
    var sum = 1
    var last = 1
    for(n <- 1 to 500; i <- 1 to 4) {
      last += 2 * n
      sum += last
    }
    sum
  }
}

