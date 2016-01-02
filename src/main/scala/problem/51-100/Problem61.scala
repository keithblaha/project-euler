package com.keithblaha.euler.problem

import com.keithblaha.euler.util.Sequences._

class Problem61 extends EulerProblem {
  val triangulars = triangularsTo(9999).filter(_ > 999).toSet
  val squares = squaresTo(9999).filter(_ > 999).toSet
  val pentagonals = pentagonalsTo(9999).filter(_ > 999).toSet
  val hexagonals = hexagonalsTo(9999).filter(_ > 999).toSet
  val heptagonals = heptagonalsTo(9999).filter(_ > 999).toSet
  val octagonals = octagonalsTo(9999).filter(_ > 999).toSet

  override def solution = (for {
    n1 <- Stream.from(1000).filter(_ <= 9999).map(_.toLong)
    sets1 = Seq(triangulars, squares, pentagonals, hexagonals, hexagonals, heptagonals, octagonals)
    container1 = sets1.find(_.contains(n1))
    if container1.isDefined
    sets2 = sets1.filterNot(_ == container1.get)

    n2 <- (0 to 99).map(x => (n1 % 100) * 100 + x)
    container2 = sets2.find(_.contains(n2))
    if container2.isDefined
    sets3 = sets2.filterNot(_ == container2.get)

    n3 <- (0 to 99).map(x => (n2 % 100) * 100 + x)
    container3 = sets3.find(_.contains(n3))
    if container3.isDefined
    sets4 = sets3.filterNot(_ == container3.get)

    n4 <- (0 to 99).map(x => (n3 % 100) * 100 + x)
    container4 = sets4.find(_.contains(n4))
    if container4.isDefined
    sets5 = sets4.filterNot(_ == container4.get)

    n5 <- (0 to 99).map(x => (n4 % 100) * 100 + x)
    container5 = sets5.find(_.contains(n5))
    if container5.isDefined
    sets6 = sets5.filterNot(_ == container5.get)

    n6 = (n5 % 100) * 100 + n1 / 100
    container6 = sets6.find(_.contains(n6))
    if container6.isDefined
  } yield (n1 + n2 + n3 + n4 + n5 + n6)).head
}

