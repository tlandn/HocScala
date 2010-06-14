import java.util.Date
import java.lang.reflect._

println("Today is " + new Date())

val methods = getClass.getMethods()
methods.foreach { method: Method => println(method.getName()) }
methods.foreach { method => println(method.getName()) }
methods.foreach { _:Method => println(_.getName()) }
