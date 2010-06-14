object StringUtil {
  def joiner(strings: List[String], separator: String = " "): String =
    strings.mkString(separator)
}

import StringUtil._ // Import the joiner methods.
println(joiner(List("Programming", "Scala")))
println(joiner(List("Programming", "Scala")))
println(joiner(strings = List("Programming", "Scala")))
println(joiner(List("Programming", "Scala"), " ")) // #1
println(joiner(List("Programming", "Scala"), separator = " ")) // #2
println(joiner(strings = List("Programming", "Scala"), separator = " "))

def factorial(i: Int) = {
  def fact(i: Int, accumulator: Int): Int = {
    if (i <= 1)
      accumulator
    else
      fact(i - 1, i * accumulator)
  }
  fact(i, 1)
}
println( factorial(0) )
println( factorial(1) )
println( factorial(2) )
println( factorial(3) )
println( factorial(4) )
println( factorial(5) )


def tupleator(x1: Any, x2: Any, x3: Any) = (x1, x2, x3)
val t = tupleator("Hello", 1, 2.3)

println( "Print the whole tuple: "  + t )

println( "Print the first item: "   + t._1 )
println( "Print the second item: "  + t._2 )
println( "Print the third item: "   + t._3 )
val (t1, t2, t3) = tupleator("World", '!', 0x22)
println( t1 + " " + t2 + " " + t3 )

val stateCapitals = Map(
  "Alabama" -> "Montgomery",
  "Alaska" -> "Juneau",
  // ...
  "Wyoming" -> "Cheyenne")
println( "Get the capitals wrapped in Options:" )
println( "Alabama: " + stateCapitals.get("Alabama") )
println( "Wyoming: " + stateCapitals.get("Wyoming") )
println( "Unknown: " + stateCapitals.get("Unknown") )
println( "Get the capitals themselves out of the Options:" )
println( "Alabama: " + stateCapitals.get("Alabama").get )
println( "Wyoming: " + stateCapitals.get("Wyoming").getOrElse("Oops!") )
println( "Unknown: " + stateCapitals.get("Unknown").getOrElse("Oops2!") )


def writeAboutBigInteger() = {
  import java.math.BigInteger.{
    ONE => _,
    TEN,
    ZERO => JAVAZERO }
  // ONE is effectively undefined
  // println( "ONE: "+ONE )
  println( "TEN: "+ TEN)
  println( "ZERO: "+JAVAZERO )
}
writeAboutBigInteger()
