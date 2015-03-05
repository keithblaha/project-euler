import scala.annotation.tailrec

object Main extends App {
  @tailrec def fact(i: Int, c: BigInt = BigInt(1)): BigInt = {
    if(i <= 1) c
    else fact(i - 1, i * c)
  }
  def choose(n: Int, k: Int) = fact(n) / (fact(k) * fact(n - k))

  val solution = {
    choose(40, 20)
  }
  Console.println(solution)
}
