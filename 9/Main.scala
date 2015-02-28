object Main extends App {
  def solution: Int = {
    val limit = 1000
    for(c <- 3 to limit - 3; b <- 2 until c; a <- 1 until b) {
      if(a + b + c == limit && a * a + b * b == c * c) {
        return a * b * c
      }
    }
    -1
  }
  Console.println(solution)
}
