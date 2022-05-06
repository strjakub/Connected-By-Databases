
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*13.13*/title),format.raw/*13.18*/("""</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" media="screen" href='"""),_display_(/*15.50*/routes/*15.56*/.Assets.versioned("stylesheets/main.css")),format.raw/*15.97*/("""'>
</head>

<body>
    <header>
        <nav class="navbar">
            <div class="logo">TOURNAMENTS</div>
                <!-- NAVIGATION MENU -->
            <ul class="nav-links">
                    <!-- USING CHECKBOX HACK -->
                <input type="checkbox" id="checkbox_toggle" />
                <label for="checkbox_toggle" class="hamburger">&#9776;</label>
                    <!-- NAVIGATION MENUS -->
                <div class="menu">
                    <li><a href=""""),_display_(/*29.35*/routes/*29.41*/.HomeController.home()),format.raw/*29.63*/("""">Home</a></li>
                    <li><a href=""""),_display_(/*30.35*/routes/*30.41*/.HomeController.tournaments()),format.raw/*30.70*/("""">Tournaments</a></li>
                    <li><a href=""""),_display_(/*31.35*/routes/*31.41*/.HomeController.teams()),format.raw/*31.64*/("""">Teams</a></li>
                    <li><a href=""""),_display_(/*32.35*/routes/*32.41*/.HomeController.players()),format.raw/*32.66*/("""">Players</a></li>
                    <li><a href=""""),_display_(/*33.35*/routes/*33.41*/.HomeController.panel()),format.raw/*33.64*/("""">Panel</a></li>
                    <li><a href=""""),_display_(/*34.35*/routes/*34.41*/.AuthUserController.logout()),format.raw/*34.69*/("""">Logout</a></li>
                </div>
            </ul>
        </nav>
    </header>
    <article>
        <section>
            """),_display_(/*41.14*/content),format.raw/*41.21*/("""
        """),format.raw/*42.9*/("""</section>
        <aside>
            """),_display_(/*44.14*/commonSidebar()),format.raw/*44.29*/("""
        """),format.raw/*45.9*/("""</aside>
    </article>
    <footer>
        """),_display_(/*48.10*/commonFooter()),format.raw/*48.24*/("""
    """),format.raw/*49.5*/("""</footer>
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
                  SOURCE: app/views/main.scala.html
                  HASH: ad104767a2eccf3de87d2de3b72f98cfaad09915
                  MATRIX: 991->265|1116->295|1146->299|1230->356|1256->361|1418->496|1433->502|1495->543|2027->1048|2042->1054|2085->1076|2163->1127|2178->1133|2228->1162|2313->1220|2328->1226|2372->1249|2451->1301|2466->1307|2512->1332|2593->1386|2608->1392|2652->1415|2731->1467|2746->1473|2795->1501|2962->1641|2990->1648|3027->1658|3096->1700|3132->1715|3169->1725|3245->1774|3280->1788|3313->1794
                  LINES: 26->7|31->7|33->9|37->13|37->13|39->15|39->15|39->15|53->29|53->29|53->29|54->30|54->30|54->30|55->31|55->31|55->31|56->32|56->32|56->32|57->33|57->33|57->33|58->34|58->34|58->34|65->41|65->41|66->42|68->44|68->44|69->45|72->48|72->48|73->49
                  -- GENERATED --
              */
          