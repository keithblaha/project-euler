package com.keithblaha.euler.util

import scala.annotation.tailrec

object Combinatorics {
  @tailrec def factorial(i: Int, c: BigInt = BigInt(1)): BigInt = {
    if(i <= 1) c
    else factorial(i - 1, i * c)
  }

  def choose(n: Int, k: Int) = factorial(n) / (factorial(k) * (factorial(n-k)))
}

