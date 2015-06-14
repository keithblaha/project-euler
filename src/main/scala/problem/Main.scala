package com.keithblaha.euler.problem

object Main extends App {
  val problems = args.flatMap(a => {
    if(a.contains("-")) {
      val s = a.split("-")
      s.head.toInt to s.last.toInt
    } else {
      Seq(a.toInt)
    }
  })

  problems.foreach(p => {
    val start = System.currentTimeMillis
    val s = Class.forName("com.keithblaha.euler.problem.Problem" + p).newInstance.asInstanceOf[EulerProblem].solution
    val t = System.currentTimeMillis - start
    Console.println(s"Problem $p's solution $s was found in ${t}ms")
  })
}

