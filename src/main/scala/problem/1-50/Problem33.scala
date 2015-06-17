package com.keithblaha.euler.problem

class Problem33 extends EulerProblem {
  override def solution = {
    val digitCancelingFractions = for {
      numerator <- (12 to 98).filterNot(n => n % 10 == 0 || n % 11 == 0)
      denominator <- (numerator + 1 to 98).filterNot(n => n % 10 == 0 || n % 11 == 0)
                       .filter(n => n.toString.contains(numerator.toString.charAt(0)) ^ n.toString.contains(numerator.toString.charAt(1)))
      digitCanceledFraction = {
        val f = denominator.toString.indexOf(numerator.toString.charAt(0))
        if(f > -1) {
          numerator.toString.charAt(1).asDigit.toFloat / denominator.toString.charAt(f ^ 1).asDigit
        }
        else {
          val s = denominator.toString.indexOf(numerator.toString.charAt(1))
          numerator.toString.charAt(0).asDigit.toFloat / denominator.toString.charAt(s ^ 1).asDigit
        }
      }
      if numerator.toFloat / denominator == digitCanceledFraction
    } yield (numerator, denominator)

    val p = digitCancelingFractions.reduce((x, y) => (x._1 * y._1, x._2 * y._2))
    (p._2.toFloat / BigInt(p._1).gcd(p._2).toInt).toInt
  }
}

