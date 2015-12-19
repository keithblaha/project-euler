package com.keithblaha.euler.problem

class Problem59 extends EulerProblem {
  val ciphered = resource.mkString.trim.split(',').map(_.toInt).toList

  override def solution = (for {
    password <- (97 to 122).combinations(3).flatMap(_.permutations)
    keys = Stream.continually(password).flatten.take(ciphered.size).toList
    deciphered = ciphered.zip(keys).map(t => (t._1 ^ t._2).toChar).mkString
  } yield deciphered).find(_.contains(" the ")).get.map(_.toInt).sum
}

