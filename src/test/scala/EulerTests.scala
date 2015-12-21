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
    23 -> 4179871,
    24 -> "2783915460",
    25 -> 4782,
    26 -> 983,
    27 -> -59231,
    28 -> 669171001,
    29 -> 9183,
    30 -> 443839,
    31 -> 73682,
    32 -> 45228,
    33 -> 100,
    34 -> 40730,
    35 -> 55,
    36 -> 872187,
    37 -> 748317,
    38 -> 932718654,
    39 -> 840,
    40 -> 210,
    41 -> 7652413,
    42 -> 162,
    43 -> 16695334890L,
    44 -> 5482660,
    45 -> 1533776805L,
    46 -> 5777,
    47 -> 134043,
    48 -> "9110846700",
    49 -> "296962999629",
    50 -> 997651,
    51 -> 121313,
    52 -> 142857,
    53 -> 4075,
    54 -> 376,
    55 -> 249,
    56 -> 972,
    57 -> 153,
    58 -> 26241,
    59 -> 107359,
    /* ignore since it takes so long
    60 -> 26033,
    */
    67 -> 7273
  )

  answersToProblems.keys.toSeq.sorted.foreach(p => {
    s"Problem $p" should "return the correct solution" in {
      val solution = Class.forName("com.keithblaha.euler.problem.Problem" + p).newInstance.asInstanceOf[EulerProblem].solution
      solution should be (answersToProblems(p))
    }
  })
}

