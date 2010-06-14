class ShareCodeImperative extends org.scalatest.Suite
  with org.scalatest.BeforeAndAfter {
  var list : java.util.ArrayList[Integer] = _

  override def beforeEach() { list = new java.util.ArrayList[Integer] }

  override def afterEach() { list = null }

  def testListEmptyOnCreate() {
    expect(0, "Expected size to be 0") { list.size() }
  }

  def testGetOnEmptyList() {
    intercept[IndexOutOfBoundsException] { list.get(0) }
  }
}

(new ShareCodeImperative).execute()
