class Marker private (val color: String) {
  println("Creating " + this)
  override def toString() : String = "marker color " + color
}
object Marker {
  private val markers = Map(
    "red" -> new Marker("red" ),
    "blue" -> new Marker("blue" ),
    "green" -> new Marker("green" )
  )
  def getMarker(color: String) =
    if (markers.contains(color)) markers(color) else null
}

println(Marker getMarker "blue")
println(Marker getMarker "blue")
println(Marker getMarker "red")
println(Marker getMarker "red")

def max(values: Int*) = values.foldLeft(values(0)) { Math.max }

println(max(2, 5, 3, 7, 1, 6))

val numbers = Array(2, 5, 3, 7, 1, 6)
//println(max(numbers)) // type mismatch error
println(max(numbers: _*))


def totalResultOverRange(number: Int, codeBlock: Int => Int) : Int = {
  var result = 0
  for (i <- 1 to number) {
    result += codeBlock(i)
  }
  result
}

println(totalResultOverRange(11, i => i))
println(totalResultOverRange(7, i => if (i % 2 == 0) i else 0))

def inject(arr: Array[Int], initial: Int, operation: (Int, Int) => Int) : Int = {
  var carryOver = initial
  arr.foreach(element => carryOver = operation(carryOver, element) )
  carryOver
}

val array = Array(2, 3, 5, 1, 6, 4)
val sum = inject(array, 0, (carryOver, elem) => carryOver + elem)
println("Sum of elements in array " + array.toString() + " is " + sum)

val max = inject(array, Integer.MIN_VALUE,
    (carryOver, elem) => Math.max(carryOver, elem)
  )
println("Max of elements in array " + array.toString() + " is " + max)



class Resource private() {
  println("Starting transaction..." )
  private def cleanUp() { println("Ending transaction..." ) }
  def op1 = println("Operation 1" )
  def op2 = println("Operation 2" )
  def op3 = println("Operation 3" )
}
object Resource {
  def use(codeBlock: Resource => Unit) {
    val resource = new Resource
    try {
      codeBlock(resource)
    }
    finally {
      resource.cleanUp()
    }
  }
}

Resource.use { re =>
  re.op1
  re.op2
}

def loopThrough(number: Int)(closure: Int => Unit) {
  for (i <- 1 to number) { closure(i) }
}

var result = 0
val addIt = { value:Int => result += value }

loopThrough(10) { addIt }
println("Total of values from 1 to 10 is " + result)
result = 0
loopThrough(5) { addIt }
println("Total of values from 1 to 5 is " + result)
loopThrough(5) { result += _ }
println("Total of values from 1 to 5 is " + result)

var product = 1
loopThrough(5) { product *= _ }
println("Product of values from 1 to 5 is " + product)

