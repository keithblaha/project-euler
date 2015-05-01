package com.keithblaha.euler.problem

class Problem31 extends EulerProblem {
  def coinPermutations(l: Int, c: Seq[Int], t: Int = 0, m: Int = 0): Int = {
    if(t == l) 1
    else c.filter(v => t + v <= l && m <= v).map(v => coinPermutations(l, c, t + v, v)).sum
  }

  override def solution = coinPermutations(200, Seq(1, 2, 5, 10, 20, 50, 100, 200))
}

