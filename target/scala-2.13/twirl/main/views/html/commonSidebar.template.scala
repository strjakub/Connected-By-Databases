
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


Seq[Any](_display_(/*2.2*/defining(play.core.PlayVersion.current)/*2.41*/ { version =>_display_(Seq[Any](format.raw/*2.54*/("""
        """),format.raw/*3.9*/("""<div class="aside-content">
          <h3>Related Resources</h3>
          <ul>
            <li><a href="https://pzpn.pl/" target="_blank">PZPN</a></li>
            <li><a href="https://pzpn.pl/" target="_blank">PZPN</a></li>
            <li><a href="https://pzpn.pl/" target="_blank">PZPN</a></li>
            <li><a href="https://pzpn.pl/" target="_blank">PZPN</a></li>
            <li><a href="https://pzpn.pl/" target="_blank">PZPN</a></li>
          </ul>
        </div>
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
                  HASH: 6c54230ff29cc0129dcf948b63318ea933f82eea
                  MATRIX: 730->1|826->5|873->44|923->57|958->66
                  LINES: 21->1|26->2|26->2|26->2|27->3
                  -- GENERATED --
              */
          