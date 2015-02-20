import scala.collection.mutable.Buffer
import scala.util.control.Breaks._

object Main extends App {
  val solution = {
    val fibs = Buffer(1,2)
    breakable {
      while(true) {
        val newFib = fibs.takeRight(2).sum
        if(newFib <= 4000000) {
          fibs += newFib
        }
        else break
      }
    }
    fibs.filter(_ % 2 == 0).sum
  }
  Console.println(solution)
}
