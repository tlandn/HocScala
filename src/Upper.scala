class Upper {
  def upper(strings: String*)  = {
    strings.map((s:String) => s.toUpperCase())
  }

  def upper1(strings: String*) = strings.map(_.toUpperCase())


}
