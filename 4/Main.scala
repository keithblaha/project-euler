object Main extends App {
  def isPalindrome(s: String): Boolean =  {
    if (s.length <= 1) return true
    else if (s.head == s.last) return isPalindrome(s.slice(1, s.length-1))
    else return false
  }

  var max = -1
  val solution = {
    (100 until 1000).foreach(x => {
      (100 until 1000).foreach(y => {
        val n = x * y
        if(isPalindrome(n.toString) && n > max) max = n
      })
    })
    max
  }
  Console.println(solution)
}
