object Main extends App {
  // it'd probably be faster to generate the multiples rather than filter down from all possibilties... oh well
  val solution = (1 until 1000).filter(x => x % 3 == 0 || x % 5 == 0).sum
  Console.println(solution)
}
