trait Friend {
  val name: String
  def listen() = println("Your friend " + name + " is listening")
}

class Human(val name: String) extends Friend

class Man(override val name: String) extends Human(name)
class Woman(override val name: String) extends Human(name)

class Animal
class Dog(val name: String) extends Animal with Friend {
  //optionally override method here.
  override def listen = println(name + "'s listening quietly" )
}

val john = new Man("John")
val sara = new Woman("Sara")
val comet = new Dog("Comet")

john.listen
sara.listen
comet.listen

val mansBestFriend : Friend = comet
mansBestFriend.listen

def helpAsFriend(friend: Friend) = friend listen

helpAsFriend(sara)
helpAsFriend(comet)

class Cat(val name: String) extends Animal
def useFriend(friend: Friend) = friend listen

val snowy = new Cat("Snowy" ) with Friend
val friend : Friend = snowy
friend.listen
useFriend(snowy)


abstract class Check {
  def check() : String = "Checked Application Details..."
}

trait CreditCheck extends Check {
  override def check() : String = "Checked Credit..." + super.check
}
trait EmploymentCheck extends Check {
  override def check() : String = "Checked Employment..." + super.check()
}
trait CriminalRecordCheck extends Check {
  override def check() : String = "Check Criminal Records..." + super.check()
}

val apartmentApplication = new Check with CreditCheck with CriminalRecordCheck
println(apartmentApplication check)

val emplomentApplication = new Check with CriminalRecordCheck with EmploymentCheck
println(emplomentApplication check)


abstract class Writer {
  def writeMessage(message: String)
}

trait UpperCaseWriter extends Writer {
  abstract override def writeMessage(message: String) =
    super.writeMessage(message toUpperCase)
}
trait ProfanityFilteredWriter extends Writer {
  abstract override def writeMessage(message: String) =
    super.writeMessage(message replace("stupid" , "s-----" ))
}

class StringWriterDelegate extends Writer {
  val writer = new java.io.StringWriter
  def writeMessage(message: String) = writer.write(message)
  override def toString() : String = writer.toString
}

val myWriterProfanityFirst =
  new StringWriterDelegate with UpperCaseWriter with ProfanityFilteredWriter
val myWriterProfanityLast =
  new StringWriterDelegate with ProfanityFilteredWriter with UpperCaseWriter
myWriterProfanityFirst writeMessage "There is no sin except stupidity"
myWriterProfanityLast writeMessage "There is no sin except stupidity"

println(myWriterProfanityFirst)
println(myWriterProfanityLast)
