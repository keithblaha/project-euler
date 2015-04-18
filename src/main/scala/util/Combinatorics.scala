package com.keithblaha.euler.util

import scala.annotation.tailrec

object Combinatorics {
  @tailrec def factorial(n: Int, a: BigInt = BigInt(1)): BigInt = {
    if(n <= 1) a
    else factorial(n - 1, n * a)
  }

  def choose(n: Int, k: Int) = factorial(n) / (factorial(k) * (factorial(n-k)))
}

