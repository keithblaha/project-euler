package com.keithblaha.euler.problem

class Problem17 extends EulerProblem {
  val wordLengthMap = Map(
    0 -> "".length,
    1 -> "one".length,
    2 -> "two".length,
    3 -> "three".length,
    4 -> "four".length,
    5 -> "five".length,
    6 -> "six".length,
    7 -> "seven".length,
    8 -> "eight".length,
    9 -> "nine".length,
    10 -> "ten".length,
    11 -> "eleven".length,
    12 -> "twelve".length,
    13 -> "thirteen".length,
    14 -> "fourteen".length,
    15 -> "fifteen".length,
    16 -> "sixteen".length,
    17 -> "seventeen".length,
    18 -> "eighteen".length,
    19 -> "nineteen".length,
    20 -> "twenty".length,
    30 -> "thirty".length,
    40 -> "forty".length,
    50 -> "fifty".length,
    60 -> "sixty".length,
    70 -> "seventy".length,
    80 -> "eighty".length,
    90 -> "ninety".length,
    100 -> "hundred".length,
    1000 -> "thousand".length
  )

  val And = "and"
  def andLength(n: Int) = if(n % 100 > 0) And.length + wordLength(n % 100) else 0

  def wordLength(n: Int): Int = {
    if(n <= 20) wordLengthMap(n)
    else if(n < 100) wordLengthMap(n / 10 * 10) + wordLength(n % 10)
    else if(n < 1000) wordLengthMap(n / 100) + wordLengthMap(100) + andLength(n)
    else wordLengthMap(1) + wordLengthMap(1000)
  }

  override def solution = (1 to 1000).map(wordLength).sum
}

