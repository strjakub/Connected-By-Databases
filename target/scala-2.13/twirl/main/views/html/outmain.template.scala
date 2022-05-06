
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

object outmain extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Html,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /*
* This template is called from the `home` template. This template
* handles the rendering of the page header and body tags. It takes
* two arguments, a `String` for the title of the page and an `Html`
* object to insert into the body of the page.
*/
  def apply/*7.2*/(title: String)(content: Html)(implicit flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.55*/("""

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
            """),format.raw/*26.13*/("""<div class="flash-message">
                """),_display_(/*27.18*/flash/*27.23*/.get("error")),format.raw/*27.36*/("""
                """),_display_(/*28.18*/flash/*28.23*/.get("success")),format.raw/*28.38*/("""
            """),format.raw/*29.13*/("""</div>
        </article>
        <footer>
            """),_display_(/*32.14*/commonFooter()),format.raw/*32.28*/("""
        """),format.raw/*33.9*/("""</footer>
    </body>

</html>"""))
      }
    }
  }

  def render(title:String,content:Html,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)(flash)

  def f:((String) => (Html) => (Flash) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => (flash) => apply(title)(content)(flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/outmain.scala.html
                  HASH: c7d298e26a6037e585d1c663b6ae941fbbec1eaf
                  MATRIX: 995->260|1143->313|1173->317|1265->382|1291->387|1461->530|1476->536|1539->577|1773->784|1801->791|1843->805|1916->851|1930->856|1964->869|2010->888|2024->893|2060->908|2102->922|2188->981|2223->995|2260->1005
                  LINES: 26->7|31->7|33->9|37->13|37->13|39->15|39->15|39->15|49->25|49->25|50->26|51->27|51->27|51->27|52->28|52->28|52->28|53->29|56->32|56->32|57->33
                  -- GENERATED --
              */
          