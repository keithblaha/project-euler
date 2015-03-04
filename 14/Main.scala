import scala.annotation.tailrec
import scala.collection.mutable.Buffer

object Main extends App {
  // could make a lot faster with memoization
  @tailrec def collatzLen(n: Long, c: Int = 0): Int = {
    if(n == 1) return c+1
    else if(n % 2 == 0) return collatzLen(n / 2, c+1)
    else return collatzLen(3 * n + 1, c+1)
  }

  val solution = {
    var max = (-1, -1)
    (1 until 1000000).foreach(n => {
      val l = collatzLen(n)
      if(l > max._2) max = (n,l)
    })
    max
  }
  Console.println(solution)
}
