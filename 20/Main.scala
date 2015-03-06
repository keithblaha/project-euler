import scala.annotation.tailrec

object Main extends App {
  @tailrec def fact(i: Int, c: BigInt = BigInt(1)): BigInt = {
    if(i <= 1) c
    else fact(i - 1, i * c)
  }

  val solution = {
    fact(100).toString.map(_.asDigit).sum
  }
  Console.println(solution)
}
