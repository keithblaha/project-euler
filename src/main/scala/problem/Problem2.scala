package com.keithblaha.euler.problem

import scala.collection.mutable.Buffer
import scala.util.control.Breaks._

class Problem2 extends EulerProblem {
  override def solution = {
    val fibs = Buffer(1,2)
    breakable {
      while(true) {
        val newFib = fibs.takeRight(2).sum
        if(newFib <= 4000000) {
          fibs += newFib
        }
        else break
      }
    }
    fibs.filter(_ % 2 == 0).sum
  }
}

