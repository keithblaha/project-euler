package com.keithblaha.euler.problem

import com.keithblaha.euler.util.NumberTriangle

class Problem18 extends EulerProblem {
  override def solution = new NumberTriangle(resource.mkString).maxPath
}

