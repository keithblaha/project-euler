object Main extends App {
  val solution = {
    BigInt(2).pow(1000).toString().map(_.asDigit).sum
  }
  Console.println(solution)
}
