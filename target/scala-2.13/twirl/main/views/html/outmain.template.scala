
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


Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">

    <head>
        <title>"""),_display_(/*13.17*/title),format.raw/*13.22*/("""</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" media="screen" href='"""),_display_(/*15.54*/routes/*15.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*15.101*/("""'>
        <link rel="stylesheet" media="screen" href='"""),_display_(/*16.54*/routes/*16.60*/.Assets.versioned("stylesheets/bootstrap.min.css")),format.raw/*16.110*/("""'>
        """),format.raw/*17.117*/("""
"""),format.raw/*18.116*/("""
    """),format.raw/*19.5*/("""</head>

    <body>
        <header>
            <nav class="navbar">
                <div class="logo">TOURNAMENTS</div>
            </nav>
        </header>
        <article>
            """),_display_(/*28.14*/content),format.raw/*28.21*/("""
            """),format.raw/*29.13*/("""<div class="flash-message">
                """),_display_(/*30.18*/flash/*30.23*/.get("error")),format.raw/*30.36*/("""
                """),_display_(/*31.18*/flash/*31.23*/.get("success")),format.raw/*31.38*/("""
            """),format.raw/*32.13*/("""</div>
        </article>
        <footer>
            """),_display_(/*35.14*/commonFooter()),format.raw/*35.28*/("""
        """),format.raw/*36.9*/("""</footer>
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
                  HASH: e7e8d5854ba86d8e99b4bb7d9736734c239947e3
                  MATRIX: 990->254|1137->308|1164->309|1252->370|1278->375|1446->516|1461->522|1524->563|1607->619|1622->625|1694->675|1734->794|1764->910|1796->915|2013->1105|2041->1112|2082->1125|2154->1170|2168->1175|2202->1188|2247->1206|2261->1211|2297->1226|2338->1239|2421->1295|2456->1309|2492->1318
                  LINES: 26->7|31->8|32->9|36->13|36->13|38->15|38->15|38->15|39->16|39->16|39->16|40->17|41->18|42->19|51->28|51->28|52->29|53->30|53->30|53->30|54->31|54->31|54->31|55->32|58->35|58->35|59->36
                  -- GENERATED --
              */
          