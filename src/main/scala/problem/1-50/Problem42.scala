package com.keithblaha.euler.problem

class Problem42 extends EulerProblem {
  val words = resource.mkString.replace("\"", "").split(',')
  val triangulars = Stream.iterate((1,1))(x=>(x._1+1,x._1+x._2+1)).takeWhile(_._2 <= 1000).map(_._2).toSet
  val charOffset = 'A'.toInt - 1

  override def solution = words.map(_.map(_.toInt - charOffset).sum).filter(triangulars.contains).size
}

