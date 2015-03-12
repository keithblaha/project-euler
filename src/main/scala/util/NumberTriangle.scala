package com.keithblaha.euler.util

class NumberTriangle(nums: String) {
  val nodes = {
    // create list of list of NumberNodes by parsing initial string
    val t = nums.split("\n").map(_.trim).filterNot(_.isEmpty)
              .map(_.split(" ").map(x=> new NumberNode(x.toInt)))

    // set parent pointers
    for(i <- (1 until t.size); j <- (0 to i)) {
      if(j != i) t(i)(j).rightParent = t(i-1)(j)
      if(j != 0) t(i)(j).leftParent = t(i-1)(j-1)
    }

    t
  }
  lazy val maxPath = nodes.last.map(_.maxValue).max

  class NumberNode(val value: Int) {
    var leftParent: NumberNode = null
    var rightParent: NumberNode = null

    lazy val maxValue: Int = {
      value + {
        if(leftParent == null && rightParent == null) 0
        else if(leftParent == null) rightParent.maxValue
        else if(rightParent == null) leftParent.maxValue
        else Math.max(rightParent.maxValue, leftParent.maxValue)
      }
    }
  }
}

