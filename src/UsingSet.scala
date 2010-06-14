val colors1 = Set("Blue" , "Green" , "Red" )
var colors = colors1
println("colors1 (colors): " + colors)
colors += "Black"
println("colors: " + colors)
println("colors1: " + colors1)

val feeds1 = Set("blog.toolshed.com" , "pragdave.pragprog.com" ,
  "pragmactic-osxer.blogspot.com" , "vita-contemplativa.blogspot.com" )
val feeds2 = Set("blog.toolshed.com" , "martinfowler.com/bliki" )


val blogSpotFeeds = feeds1 filter ( _ contains "blogspot" )
println("blogspot feeds: " + blogSpotFeeds.mkString(", " ))

val mergedFeeds = feeds1 ++ feeds2
println(feeds1)
println(feeds2)
println("# of merged feeds: " + mergedFeeds.size)

val urls = feeds1 map ( "http://" + _ )
println(urls)
println("One url: " + urls.head)
println("One url: " + urls.toString)

println(urls.toArray.apply(2))
println(urls.toArray.take(2))

println("Refresh Feeds:" )
feeds1 foreach ( feed => println(" Refreshing " + feed ) )

feeds1 foreach ( println(" Refreshing " + _ ) )
