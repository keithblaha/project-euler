package com.keithblaha.euler.problem

class Problem41 extends EulerProblem {
  def isPrime(n: Int) = {
    if(n % 2 == 0 || n <= 1) n == 2
    else Stream.from(3, 2).takeWhile(_ <= Math.sqrt(n)).find(n % _ == 0).isEmpty
  }

  // 9 and 8 digit pandigitals eliminated by divisibility rule of 3
  override def solution = "7654321".permutations.map(_.toInt).find(isPrime).get
}

