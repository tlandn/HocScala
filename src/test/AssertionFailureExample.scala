class AssertionFailureExample extends org.scalatest.Suite {
  def testAssertFailure() {
    assert(2 == List().size)
  }
}
(new AssertionFailureExample).execute()
