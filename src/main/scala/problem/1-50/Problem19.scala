package com.keithblaha.euler.problem

import java.util.Date

class Problem19 extends EulerProblem {
  override def solution = {
    // a very lazy solution
    var count = 0
    for(y <- (1 to 100); m <- (1 to 12)) {
      if(new Date(y, m, 1).getDay == 0) count += 1
    }
    count
  }
}

