
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


Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">

<head>
    <title>"""),_display_(/*13.13*/title),format.raw/*13.18*/("""</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" media="screen" href='"""),_display_(/*15.50*/routes/*15.56*/.Assets.versioned("stylesheets/bootstrap.min.css")),format.raw/*15.106*/("""'>
    <link rel="stylesheet" media="screen" href='"""),_display_(/*16.50*/routes/*16.56*/.Assets.versioned("stylesheets/main.css")),format.raw/*16.97*/("""'>
"""),format.raw/*17.105*/("""
"""),format.raw/*18.112*/("""
"""),format.raw/*19.1*/("""</head>

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
                    <li><a href=""""),_display_(/*32.35*/routes/*32.41*/.HomeController.home()),format.raw/*32.63*/("""">Home</a></li>
                    <li><a href=""""),_display_(/*33.35*/routes/*33.41*/.HomeController.tournaments()),format.raw/*33.70*/("""">Tournaments</a></li>
                    <li><a href=""""),_display_(/*34.35*/routes/*34.41*/.HomeController.teams()),format.raw/*34.64*/("""">Teams</a></li>
                    <li><a href=""""),_display_(/*35.35*/routes/*35.41*/.HomeController.players()),format.raw/*35.66*/("""">Players</a></li>
                    <li><a href=""""),_display_(/*36.35*/routes/*36.41*/.HomeController.panel()),format.raw/*36.64*/("""">Panel</a></li>
                    <li><a href=""""),_display_(/*37.35*/routes/*37.41*/.AuthUserController.logout()),format.raw/*37.69*/("""">Logout</a></li>
                </div>
            </ul>
        </nav>
    </header>
    <article>
        <section>
            """),_display_(/*44.14*/content),format.raw/*44.21*/("""
        """),format.raw/*45.9*/("""</section>
        <aside>
            """),_display_(/*47.14*/commonSidebar()),format.raw/*47.29*/("""
        """),format.raw/*48.9*/("""</aside>
    </article>
    <footer>
        """),_display_(/*51.10*/commonFooter()),format.raw/*51.24*/("""
    """),format.raw/*52.5*/("""</footer>
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
                  HASH: 4141ed4c6af9606b12c491b2997dfcf7ec955b39
                  MATRIX: 986->259|1110->290|1137->291|1217->344|1243->349|1403->482|1418->488|1490->538|1569->590|1584->596|1646->637|1678->744|1708->856|1736->857|2251->1345|2266->1351|2309->1373|2386->1423|2401->1429|2451->1458|2535->1515|2550->1521|2594->1544|2672->1595|2687->1601|2733->1626|2813->1679|2828->1685|2872->1708|2950->1759|2965->1765|3014->1793|3174->1926|3202->1933|3238->1942|3305->1982|3341->1997|3377->2006|3450->2052|3485->2066|3517->2071
                  LINES: 26->7|31->8|32->9|36->13|36->13|38->15|38->15|38->15|39->16|39->16|39->16|40->17|41->18|42->19|55->32|55->32|55->32|56->33|56->33|56->33|57->34|57->34|57->34|58->35|58->35|58->35|59->36|59->36|59->36|60->37|60->37|60->37|67->44|67->44|68->45|70->47|70->47|71->48|74->51|74->51|75->52
                  -- GENERATED --
              */
          