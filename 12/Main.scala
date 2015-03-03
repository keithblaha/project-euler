import scala.collection.mutable.Buffer
import scala.util.control.Breaks._

object Main extends App {
  // use sieve of Eratosthenes to generate a lot of primes
  val limit = 100000
  val primes = Buffer[Int]()
  val nums = (2 to limit)
  val map = scala.collection.mutable.Map() ++ nums.map((_, true)).toMap
  nums.foreach(n => {
    if(map.getOrElse(n, false)) {
      primes += n
      for(composite <- n*2 to limit by n) {
        map(composite) = false
      }
    }
  })

  def nthTriangular(n: Int) = n * (n + 1) / 2

  def numFactors(n: Int) = {
    var num = n
    val factors = Buffer[Int]()
    for(i <- primes.filter(_ <= n)) {
      while(num % i == 0) {
        factors += i
        num /= i
      }
    }
    factors.groupBy(x=>x).map(_._2.size + 1).product
  }

  val solution = {
    var n = 1
    var nth = 1
    breakable {
      while(true) {
        nth = nthTriangular(n)
        if(numFactors(nth) > 500) break
        else n += 1
      }
    }
    (n, nth)
  }
  Console.println(solution)
}
