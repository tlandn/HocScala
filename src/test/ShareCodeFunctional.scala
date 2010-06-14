class ShareCodeFunctional extends org.scalatest.Suite {
  def withList(tenFunction : (java.util.ArrayList[Integer]) => Unit) {
    val list = new java.util.ArrayList[Integer]

    try {
      tenFunction(list)
    }
    finally {
      // perform any necessary cleanup here after return
    }
  }

  def testListEmptyOnCreate() {
    withList { list => expect(0, "Expected size to be 0") { list.size() } }
  }

  def testGetOnEmptyList() {
    withList {
      list => intercept[IndexOutOfBoundsException] { list.get(0) }
    }
  }
}

(new ShareCodeFunctional).execute()
