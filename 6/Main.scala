object Main extends App {
  def sumOfSquares(n: Int) = {
    // naive:
    // (1 to n).map(x => x*x).sum
    // better:
    n * (n + 1) * (2*n + 1) / 6
  }
  def squareOfSums(n: Int) = {
    // naive:
    // val s = (1 to n).sum
    // better:
    val s = n * (n + 1) / 2
    s * s
  }
  val solution = {
    squareOfSums(100) - sumOfSquares(100)
  }
  Console.println(solution)
}
