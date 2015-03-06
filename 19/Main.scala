import java.util.Date

object Main extends App {
  val solution = {
    // a very lazy solution
    var count = 0
    for(y <- (1 to 100); m <- (1 to 12)) {
      if(new Date(y, m, 1).getDay == 0) count += 1
    }
    count
  }
  Console.println(solution)
}
