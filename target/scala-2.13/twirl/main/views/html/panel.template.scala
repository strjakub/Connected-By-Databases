
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
                </article>
                <aside>
                    """),_display_(/*12.22*/commonSidebar()),format.raw/*12.37*/("""
                """),format.raw/*13.17*/("""</aside>
            </div>
        </section>
    """),_display_(/*16.6*/commonFooter()),format.raw/*16.20*/("""
    """)))}),format.raw/*17.6*/("""
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
                  HASH: 96b6bee536cf242d6ecd4bfe2c1ada0920acbbc9
                  MATRIX: 722->1|818->4|845->6|866->19|905->21|936->27|983->66|1033->79|1069->89|1301->294|1337->309|1382->326|1460->378|1495->392|1531->398
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|28->4|28->4|30->6|36->12|36->12|37->13|40->16|40->16|41->17
                  -- GENERATED --
              */
          