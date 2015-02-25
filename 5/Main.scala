import scala.util.control.Breaks._

object Main extends App {
  def divisibleThrough(n: Int, k: Int) = {
    (2 to k).forall(d => n % d == 0)
  }
  val solution = {
    var n = 1
    breakable {
      while(true) {
        if(divisibleThrough(n, 20)) break
        else n += 1
      }
    }
    n
  }
  Console.println(solution)
}
