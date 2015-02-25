import scala.collection.mutable.Buffer
import scala.util.control.Breaks._

object Main extends App {
  var n = 600851475143L
  var d = 2
  val factors = Buffer[Long]()
  val solution = {
    breakable {
      while(n > 1) {
        while(n % d == 0) {
          factors += d
          n = n / d
        }
        d += 1
        if(d*d > n) {
          if(n > 1) factors += n
          break
        }
      }
    }
    factors.last
  }
  Console.println(solution)
}
