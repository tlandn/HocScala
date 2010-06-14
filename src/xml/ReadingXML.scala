import scala.xml._
val someXMLInAString = """
<sammich>
  <bread>wheat</bread>
  <meat>salami</meat>
  <condiments>
    <condiment expired="true">mayo</condiment>
    <condiment expired="false">mustard</condiment>
  </condiments>
</sammich>
"""

val someXML =
<sammich>
  <bread>wheat</bread>
  <meat>salami</meat>
  <condiments>
    <condiment expired="true">mayo</condiment>
    <condiment expired="false">mustard</condiment>
  </condiments>
</sammich>
println(assert(someXML.isInstanceOf[scala.xml.Elem]))

println(someXML \ "bread")
println((someXML \ "bread").text)
println(someXML \ "condiment")
println(someXML \\ "condiment")

for (condiment <- (someXML \\ "condiment")) {
  if ((condiment \ "@expired").text == "true")
    println("the " + condiment.text + " has expired!")
}
