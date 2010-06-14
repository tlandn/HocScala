class AssertionFailureExample2 extends org.scalatest.Suite {
  def testAssertFailure() {
    //assert(2 === List().size,"Unexpected size of List")
    //expect(2, "Unexpected List size" ) { List().size }
  }

  def testGetOnEmptyList() {
  try {
    val list = new java.util.ArrayList[Integer]
    list.get(0)
    fail("Expected exception for getting element from empty list" )
  }
  catch {
    case ex: IndexOutOfBoundsException => // :) Success
  }

  def testGetOnEmptyListIntercept() {
  try {
    val list = new java.util.ArrayList[Integer]
    intercept[IndexOutOfBoundsException] { list.get(0) }
  }
  catch {
    case ex: IndexOutOfBoundsException => // :) Success
  }
}



}
  
  
}
(new AssertionFailureExample2).execute()
