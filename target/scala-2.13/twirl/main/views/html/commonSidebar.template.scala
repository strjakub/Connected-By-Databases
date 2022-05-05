
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

object commonSidebar extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""
"""),_display_(/*2.2*/defining(play.core.PlayVersion.current)/*2.41*/ { version =>_display_(Seq[Any](format.raw/*2.54*/("""
"""),format.raw/*3.1*/("""<h3>Check these!</h3>
<ul>
  <li><a href=""""),_display_(/*5.17*/routes/*5.23*/.HomeController.home()),format.raw/*5.45*/("""">Home</a>
  <li><a href=""""),_display_(/*6.17*/routes/*6.23*/.HomeController.tournaments()),format.raw/*6.52*/("""">Tournaments</a>
  <li><a href=""""),_display_(/*7.17*/routes/*7.23*/.HomeController.teams()),format.raw/*7.46*/("""">Teams</a>
  <li><a href=""""),_display_(/*8.17*/routes/*8.23*/.HomeController.players()),format.raw/*8.48*/("""">Players</a>
  <li><a href=""""),_display_(/*9.17*/routes/*9.23*/.HomeController.panel()),format.raw/*9.46*/("""">Panel</a>
</ul>
<h3>Related Resources</h3>
<ul>
  <li><a href="https://pzpn.pl/" target="_blank">PZPN</a></li>
  <li><a href="https://pzpn.pl/" target="_blank">PZPN</a></li>
  <li><a href="https://pzpn.pl/" target="_blank">PZPN</a></li>
  <li><a href="https://pzpn.pl/" target="_blank">PZPN</a></li>
  <li><a href="https://pzpn.pl/" target="_blank">PZPN</a></li>
</ul>
""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/commonSidebar.scala.html
                  HASH: 62c02ad4b862a404424cafc588f72bf4e92ae4df
                  MATRIX: 730->1|826->3|854->6|901->45|951->58|979->60|1050->105|1064->111|1106->133|1160->161|1174->167|1223->196|1284->231|1298->237|1341->260|1396->289|1410->295|1455->320|1512->351|1526->357|1569->380
                  LINES: 21->1|26->1|27->2|27->2|27->2|28->3|30->5|30->5|30->5|31->6|31->6|31->6|32->7|32->7|32->7|33->8|33->8|33->8|34->9|34->9|34->9
                  -- GENERATED --
              */
          