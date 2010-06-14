val feeds = List("blog.toolshed.com", "pragdave.pragprog.com",
  "dimsumthinking.com/blog")

println("First feed: " + feeds.head)
println("Second feed: " + feeds(1))

val prefixedList = "forums.pragprog.com/forums/87" :: feeds
println("First Feed In Prefixed: " + prefixedList.head)

val feedsWithForums =
feeds ::: List("forums.pragprog.com/forums/87", "forums.pragprog.com/forums/55")
println("First feed in feeds with forum: " + feedsWithForums.head)
println("Last feed in feeds with forum: " + feedsWithForums.last)

val appendedList = feeds ::: List("agiledeveloper.com/blog")
println("Last Feed In Appended: " + appendedList.last)

println("Feeds with blog: " + feeds.filter(_ contains "blog").mkString(", "))
println("All feeds have com: " + feeds.forall(_ contains "com"))
println("All feeds have dave: " + feeds.forall(_ contains "dave"))
println("Any feed has dave: " + feeds.exists(_ contains "dave"))
println("Any feed has bill: " + feeds.exists(_ contains "bill"))

println("Feed url lengths: " + feeds.map(_.length).mkString(", "))

val total = feeds.foldLeft(0) {(total, feed) => total + feed.length}
println("Total length of feed urls: " + total)

val total2 = (0 /: feeds) {(total, feed) => total + feed.length}
println("Total length of feed urls: " + total2)

val total3 = (0 /: feeds) {_ + _.length}
println("Total length of feed urls: " + total3)

class Cow {
  def ^(moon: Moon) = println("Cow jumped over the moon")
}
class Moon {
  def ^:(cow: Cow) = println("This cow jumped over the moon too")
}

val cow = new Cow
val moon = new Moon
cow ^ moon
cow ^: moon

class Person(val firstName: String, val lastName: String)
object Person {
  def apply(firstName: String, lastName: String): Person =
    new Person(firstName, lastName)
}
val friends = List(Person("Brian", "Sletten"), Person("Neal", "Ford"),
  Person("Scott", "Davis"), Person("Stuart", "Halloway"))
val lastNames = for (friend <- friends; lastName = friend.lastName) yield lastName
println(lastNames.mkString(", "))


for (i <- 1 to 3; j <- 4 to 6) {
  print("[" + i + "," + j + "] ")
}


val str = """In his famous inaugural speech, John F. Kennedy said
          "And so, my fellow Americans: ask not what your country can do
	for you-ask what you can do for your country." He then proceeded
	to speak to the citizens of the World..."""
println("\n" + str)

val str1 = "hello"
val str2 = "hello"
val str3 = new String("hello" )
println(str1 == str2) // Equivalent to Java's str1.equals(str2)
println(str1 eq str2) // Equivalent to Java's str1 == str2
println(str1 == str3)
println(str1 eq str3)
