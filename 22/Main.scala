import scala.io.Source

object Main extends App {
  val charOffset = 'A'.toInt - 1
  val names = Source.fromFile("p022_names.txt").getLines.toSeq.head
                .stripPrefix("\"").stripSuffix("\"").split("\",\"").sorted

  val solution = {
    var n = 0
    names.map(name => {
      n += 1
      name.map(_.toInt - charOffset).sum * n
    }).sum
  }
  Console.println(solution)
}
