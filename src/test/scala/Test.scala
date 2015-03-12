package com.keithblaha.euler.problem

import org.scalatest._

class EulerTests extends FlatSpec with Matchers {
  val answersToProblems = Map(
    1 -> 233168,
    2 -> 4613732,
    3 -> 6857,
    4 -> 906609,
    5 -> 232792560,
    6 -> 25164150,
    7 -> 104743,
    8 -> 23514624000L,
    9 -> 31875000,
    10 -> 142913828922L,
    11 -> 70600674,
    12 -> 76576500,
    13 -> 5537376230L,
    14 -> 837799,
    15 -> 137846528820L,
    16 -> 1366,
    17 -> 21124,
    18 -> 1074,
    19 -> 171,
    20 -> 648,
    21 -> 31626,
    22 -> 871198282,
    67 -> 7273
  )

  answersToProblems.keys.toSeq.sorted.foreach(p => {
    s"""Problem $p""" should "return the correct solution" in {
      val solution = Class.forName("com.keithblaha.euler.problem.Problem" + p).newInstance.asInstanceOf[EulerProblem].solution
      solution should be (answersToProblems(p))
    }
  })
}

