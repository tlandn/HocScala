import java.io._

abstract class BulkReader {
  type In
  val source: In

  def read: String
}
class StringBulkReader(val source: String) extends BulkReader {
  type In = String

  def read = source
}
class FileBulkReader(val source: File) extends BulkReader {
  type In = File

  def read = {
    val in = new BufferedInputStream(new FileInputStream(source))
    val numBytes = in.available()
    val bytes = new Array[Byte](numBytes)
    in.read(bytes, 0, numBytes)
    new String(bytes)
  }
}
println(new StringBulkReader("Hello Scala!") read)
//println( new FileBulkReader(new File("abstract-types-script.scala")).read )          

def isEven(n: Int) = (n % 2) == 0
List(1, 2, 3, 4) filter isEven foreach println

List(1, 2, 3, 4).filter(isEven).foreach(println)

val list = List('b', 'c', 'd')
val x = 'a' :: list ++ List('e', 'f')
println(x)

val dogBreeds = List("Doberman", "Yorkshire Terrier", "Dachshund",
  "Scottish Terrier", "Great Dane", "Portuguese Water Dog")
for (breed <- dogBreeds)
  println(breed)

for (breed <- dogBreeds
     if breed.contains("Terrier")
) println(breed)


for (breed <- dogBreeds
  if breed.contains("Terrier");
  if !breed.startsWith("Yorkshire")
) println(breed)


val filteredBreeds = for {
  breed <- dogBreeds
  if breed.contains("Terrier")
  if !breed.startsWith("Yorkshire")
} yield breed
println(filteredBreeds)

val bools = List(true, false)
for (bool <- bools) {
  bool match {
    case true => println("heads")
    case false => println("tails")
    case _ => println("something other than heads or tails (yikes!)")
  }
}


import scala.util.Random
val randomInt = new Random().nextInt(10)
randomInt match {
  case 7 => println("lucky seven!")
  case otherNumber => println("boo, got boring ol' " + otherNumber)
}

val sundries = List(23, "Hello", 8.5, 'q')
for (sundry <- sundries) {
  sundry match {
    case i:Int => println("got an Integer: " + i)
    case s: String => println("got a String: " + s)
    case f: Double => println("got a Double: " + f)
    case other => println("got something else: " + other)
  }
}

//val willWork = List(1, 3, 23, 90)
//val willNotWork = List(4, 18, 52)
//val empty = List()
//for (l <- List(willWork, willNotWork, empty)) {
//  l match {
//    case List(_, 3, _, _) => println("Four elements, with the 2nd being '3'.")
//    case List(_*) => println("Any other list with 0 or more elements.")
//  }
//}

val tupA = ("Good", "Morning!")
val tupB = ("Guten", "Tag!")
for (tup <- List(tupA, tupB)) {
  tup match {
    case (thingOne, thingTwo) if thingOne == "Good" =>
        println("A two-tuple starting with 'Good'.")
    case (thingOne, thingTwo) =>
      println("This has two things: " + thingOne + " and " + thingTwo)
    }
  }


//case class Person(name: String, age: Int)
//val alice = new Person("Alice", 25)
//val bob = new Person("Bob", 32)
//val charlie = new Person("Charlie", 32)
//
//for (person <- List(alice, bob, charlie)) {
//  person match {
//    case Person("Alice", 25) => println("Hi Alice!")
//    case Person("Bob", 32) => println("Hi Bob!")
//    case Person(name, age) =>
//      println("Who are you, " + age + " year-old person named " + name + "?")
//  }
//}


val BookExtractorRE = """Book: title=([^,]+),\s+authors=(.+)""".r
val MagazineExtractorRE = """Magazine: title=([^,]+),\s+issue=(.+)""".r
val catalog = List(
  "Book: title=Programming Scala, authors=Dean Wampler, Alex Payne",
  "Magazine: title=The New Yorker, issue=January 2009",
  "Book: title=War and Peace, authors=Leo Tolstoy",
  "Magazine: title=The Atlantic, issue=February 2009",
  "BadData: text=Who put this here??"
)
for (item <- catalog) {
  item match {
    case BookExtractorRE(title, authors) =>
      println("Book \"" + title + "\", written by " + authors)
    case MagazineExtractorRE(title, issue) =>
      println("Magazine \"" + title + "\", issue " + issue)
    case entry => println("Unrecognized entry: " + entry)
  }
}


class Role
case object Manager extends Role
case object Developer extends Role
case class Person(name: String, age: Int, role: Role)
val alice = new Person("Alice", 25, Developer)
val bob = new Person("Bob", 32, Manager)
val charlie = new Person("Charlie", 32, Developer)
for (item <- Map(1 -> alice, 2 -> bob, 3 -> charlie)) {
  item match {
    case (id, p @ Person(_, _, Manager)) => format("%s is overpaid.\n", p)
    case (id, p @ Person(_, _, _)) => format("%s is underpaid.\n", p)
  }
}

object Breed extends Enumeration {
  val doberman = Value("Doberman Pinscher")
  val yorkie = Value("Yorkshire Terrier")
  val scottie = Value("Scottish Terrier")
  val dane = Value("Great Dane")
  val portie = Value("Portuguese Water Dog")
}
// print a list of breeds and their IDs
println("ID\tBreed")
for (breed <- Breed) println(breed.id + "\t" + breed)
// print a list of Terrier breeds
println("\nJust Terriers:")
Breed.filter(_.toString.endsWith("Terrier")).foreach(println)

object WeekDay extends Enumeration {
  type WeekDay = Value
  val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
}
import WeekDay._
def isWorkingDay(d: WeekDay) = ! (d == Sat || d == Sun)
WeekDay filter isWorkingDay foreach println

