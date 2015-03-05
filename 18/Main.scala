object Main extends App {
  class NumberTriangle(nums: String) {
    val nodes = {
      // create list of list of NumberNodes by parsing initial string
      val t = nums.split("\n").map(_.trim).filterNot(_.isEmpty)
                .map(_.split("  ").map(x=> new NumberNode(x.toInt)))

      // set parent pointers
      for(i <- (1 until t.size); j <- (0 to i)) {
        if(j != i) t(i)(j).rightParent = t(i-1)(j)
        if(j != 0) t(i)(j).leftParent = t(i-1)(j-1)
      }

      t
    }
    lazy val maxPath = nodes.last.map(_.maxValue).max

    class NumberNode(val value: Int) {
      var leftParent: NumberNode = null
      var rightParent: NumberNode = null

      lazy val maxValue: Int = {
        value + {
          if(leftParent == null && rightParent == null) 0
          else if(leftParent == null) rightParent.maxValue
          else if(rightParent == null) leftParent.maxValue
          else Math.max(rightParent.maxValue, leftParent.maxValue)
        }
      }
    }
  }

  val numTri = new NumberTriangle(
  """
                                   75
                                 95  64
                               17  47  82
                             18  35  87  10
                           20  04  82  47  65
                         19  01  23  75  03  34
                       88  02  77  73  07  63  67
                     99  65  04  28  06  16  70  92
                   41  41  26  56  83  40  80  70  33
                 41  48  72  33  47  32  37  16  94  29
               53  71  44  65  25  43  91  52  97  51  14
             70  11  33  28  77  73  17  78  39  68  17  57
           91  71  52  38  17  14  91  43  58  50  27  29  48
         63  66  04  68  89  53  67  30  73  16  69  87  40  31
       04  62  98  27  23  09  70  98  73  93  38  53  60  04  23
  """
  )

  val solution = {
    numTri.maxPath
  }
  Console.println(solution)
}
