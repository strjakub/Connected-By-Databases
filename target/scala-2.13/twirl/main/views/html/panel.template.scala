
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

object panel extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Panel")/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/("""
    """),_display_(/*4.6*/defining(play.core.PlayVersion.current)/*4.45*/ { version =>_display_(Seq[Any](format.raw/*4.58*/("""

        """),format.raw/*6.9*/("""<section id="content">
            <div class="wrapper doc">
                <article>
                        <!-- CONTENT HERE -->
                    <p>PANEL INFO HERE</p>
                </article>
                <aside>
                    """),_display_(/*13.22*/commonSidebar()),format.raw/*13.37*/("""
                """),format.raw/*14.17*/("""</aside>
            </div>
        </section>
    """),_display_(/*17.6*/commonFooter()),format.raw/*17.20*/("""
    """)))}),format.raw/*18.6*/("""
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
                  SOURCE: app/views/panel.scala.html
                  HASH: 113aa9d5aadf0e222625f14b0ba7d3a9efa89155
                  MATRIX: 722->1|818->4|845->6|866->19|905->21|936->27|983->66|1033->79|1069->89|1344->337|1380->352|1425->369|1503->421|1538->435|1574->441
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|28->4|28->4|30->6|37->13|37->13|38->14|41->17|41->17|42->18
                  -- GENERATED --
              */
          