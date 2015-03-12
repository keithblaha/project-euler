package com.keithblaha.euler.util

object Sum {
  def sumTo(n: Int) = n * (n + 1) / 2

  def squareOfSumTo(n: Int) = {
    val s = sumTo(n)
    s * s
  }

  def sumOfSquaresTo(n: Int) = n * (n + 1) * (2*n + 1) / 6
}

