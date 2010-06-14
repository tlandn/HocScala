import scala.actors.Actor
import scala.actors.Actor._

// case classes for immutable messages
case class Accumulate(amount: Int)
case class Reset
case class Total

// actor definition
object Accumulator extends Actor {
  def act = {
    var sum = 0
    loop {
      react {
      case Accumulate(n) => sum += n
      case Reset => sum = 0
      case Total => reply(sum); 
      }
    }
  }
}

Accumulator.start
  for(i <- (1 to 100)) {
    Accumulator ! Accumulate(i)
}

Accumulator !? Total match {
  case result: Int => println(result)
}

Accumulator ! Total
receive {
  case result: Int => println(result)
}
