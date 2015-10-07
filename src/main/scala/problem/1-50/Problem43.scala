package com.keithblaha.euler.problem

class Problem43 extends EulerProblem {
  override def solution = (for {
    pandigital <- "0123456789".permutations
    if pandigital.slice(1,4).toInt % 2 == 0
    if pandigital.slice(2,5).toInt % 3 == 0
    if pandigital.slice(3,6).toInt % 5 == 0
    if pandigital.slice(4,7).toInt % 7 == 0
    if pandigital.slice(5,8).toInt % 11 == 0
    if pandigital.slice(6,9).toInt % 13 == 0
    if pandigital.slice(7,10).toInt % 17 == 0
  } yield pandigital.toLong).sum
}

