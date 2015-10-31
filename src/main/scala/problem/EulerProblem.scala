package com.keithblaha.euler.problem

import scala.io.Source

trait EulerProblem {
  lazy val resource = Source.fromURL(getClass.getResource(
    s"/${getClass.getSimpleName.stripPrefix("Problem")}.txt"
  ))

  def solution: Any
}

