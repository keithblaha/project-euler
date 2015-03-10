import scala.collection.mutable.Buffer

object Main extends App {
  // use sieve of Eratosthenes to generate a lot of primes
  val limit = 10000
  val primes = Buffer[Int]()
  val nums = (2 until limit)
  val map = scala.collection.mutable.Map() ++ nums.map((_, true)).toMap
  nums.foreach(n => {
    if(map.getOrElse(n, false)) {
      primes += n
      for(composite <- n*2 to limit by n) {
        map(composite) = false
      }
    }
  })

  def primeFactorization(n: Int) = {
    var num = n
    val primeFactors = Buffer[Int]()
    for(i <- primes.withFilter(_ < n)) {
      while(num % i == 0) {
        primeFactors += i
        num /= i
      }
    }
    primeFactors
  }

  def sumOfDivisors(n: Int) = {
    primeFactorization(n).groupBy(x=>x).map(x => {
      (0 to x._2.size).map(Math.pow(x._1,_)).sum
    }).product.toInt
  }

  def sumOfProperDivisors(n: Int) = sumOfDivisors(n) - n

  def amicableWith(n: Int) = {
    val d = sumOfProperDivisors(n)
    if(sumOfProperDivisors(d) == n && d != n) d
    else -1
  }

  val solution = {
    val alreadyCounted = scala.collection.mutable.Set[Int]()
    var sum = 0
    nums.foreach(n => {
      if(!alreadyCounted.exists(_ == n)) {
        val a = amicableWith(n)
        if(a > -1) {
          sum += (n + a)
          alreadyCounted += a
        }
      }
    })
    sum
  }
  Console.println(solution)
}
