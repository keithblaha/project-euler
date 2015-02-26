import scala.collection.mutable.Buffer

object Main extends App {
  // use sieve of Eratosthenes
  val limit = 1000000
  val primes = Buffer[Int]()
  val nums = (2 to limit)
  val map = scala.collection.mutable.Map() ++ nums.map((_, true)).toMap
  val solution = {
    nums.foreach(n => {
      if(map.getOrElse(n, false)) {
        primes += n
        for(composite <- n*2 to limit by n) {
          map(composite) = false
        }
      }
    })
  }
  Console.println(primes(10000))
}
