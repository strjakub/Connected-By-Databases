
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object outmain extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
* This template is called from the `home` template. This template
* handles the rendering of the page header and body tags. It takes
* two arguments, a `String` for the title of the page and an `Html`
* object to insert into the body of the page.
*/
  def apply/*7.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.32*/("""

"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">

    <head>
        <title>"""),_display_(/*13.17*/title),format.raw/*13.22*/("""</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" media="screen" href='"""),_display_(/*15.54*/routes/*15.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*15.101*/("""'>
    </head>

    <body>
        <header>
            <nav class="navbar">
                <div class="logo">TOURNAMENTS</div>
            </nav>
        </header>
        <article>
            """),_display_(/*25.14*/content),format.raw/*25.21*/("""
        """),format.raw/*26.9*/("""</article>
        <footer>
            """),_display_(/*28.14*/commonFooter()),format.raw/*28.28*/("""
        """),format.raw/*29.9*/("""</footer>
    </body>

</html>"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/outmain.scala.html
                  HASH: e6f30b12c823e6989af3c7d8c93e59ab49731d1c
                  MATRIX: 989->260|1114->290|1144->294|1236->359|1262->364|1432->507|1447->513|1510->554|1744->761|1772->768|1809->778|1879->821|1914->835|1951->845
                  LINES: 26->7|31->7|33->9|37->13|37->13|39->15|39->15|39->15|49->25|49->25|50->26|52->28|52->28|53->29
                  -- GENERATED --
              */
          