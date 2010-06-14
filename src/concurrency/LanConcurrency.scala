import scala.actors.Actor._
class Redford extends Actor {
  def act() {
    println("A lot of what acting is, is paying attention.")
  }
       
}
val robert = new Redford
robert.start

val paulNewman = actor {
  println("To be an actor, you have to be a child.")
}

val fussyActor = actor {
  loop {
    receive {
      case s: String => println("I got a String: " + s)
      case i: Int => println("I got an Int: " + i.toString)
      case _ => println("I have no idea what I just got.")
    }
  }
}
fussyActor ! "hi there"
fussyActor ! 23
fussyActor ! 3.33
