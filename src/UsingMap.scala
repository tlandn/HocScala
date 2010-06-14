val feeds = Map("Andy Hunt" -> "blog.toolshed.com" ,
  "Dave Thomas" -> "pragdave.pragprog.com" ,
  "Dan Steinberg" -> "dimsumthinking.com/blog" )

val filterNameStartWithD = feeds filterKeys( _ startsWith "D" )
println("# of Filtered: " + filterNameStartWithD.size)

val filterNameStartWithDAndBlogInFeed = feeds filter { element =>
  val (key, value) = element
  (key startsWith "D" ) && (value contains "blog" )
}
println("# of feeds with auth name D* and blog in URL: " +
  filterNameStartWithDAndBlogInFeed.size)


val filterNameStartWithDAndBlogInFeed1 = feeds filter { element =>
  (element._1 startsWith "D" ) && (element._2 contains "blog" )
}
println("# of feeds with auth name D* and blog in URL: " +
  filterNameStartWithDAndBlogInFeed1.size)


println("Get Andy's Feed: " + feeds.get("Andy Hunt" ))
println("Get Bill's Feed: " + feeds.get("Bill Who" ))

try {
  println("Get Andy's Feed Using apply(): " + feeds("Andy Hunt" ))
  print("Get Bill's Feed: " )
  println(feeds("Bill Who") )
}
catch {
  case ex : java.util.NoSuchElementException => println("Not found" )
}

val newFeeds1 = feeds.update("Venkat Subramaniam" , "agiledeveloper.com/blog" )
println("Venkat's blog in original feeds: " + feeds.get("Venkat Subramaniam" ))
println("Venkat's blog in new feed: " + newFeeds1("Venkat Subramaniam" ))

val mutableFeeds = scala.collection.mutable.Map(
    "Scala Book Forum" -> "forums.pragprog.com/forums/87" )
mutableFeeds("Groovy Book Forum" ) = "forums.pragprog.com/forums/55"
println("Number of forums: " + mutableFeeds.size)
