import scala.xml.XML
class AtomFeed(posts: Seq[Post]) {
  val feed =
  <feed xmlns="">
    <title>My Blog</title>
    <subtitle>A fancy subtitle.</subtitle>
    <link href=""/>
    <link href="" rel="self"/>
    <updated>{posts(0).atomDate}</updated>
    <author>
      <name>John Doe</name>
      <uri></uri>
    </author>
    <id></id>
    {for (post <- posts) yield
    <entry>
      <title>{post.title}</title>
      <link href={"" + post.slug + ".html"} rel="alternate"/>
      <id>{post.atomId}</id>
      <updated>{post.atomDate}</updated>
      <content type="html">{post.body}</content>
      <author>
        <name>John Doe</name>
        <uri></uri>
      </author>
    </entry>
    }
  </feed>
  def write = XML.saveFull("/tmp/atom-example.xml", feed, "UTF-8", true, null)
}
