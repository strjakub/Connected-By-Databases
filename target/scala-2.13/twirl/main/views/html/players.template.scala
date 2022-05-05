
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

object players extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Players")/*3.17*/ {_display_(Seq[Any](format.raw/*3.19*/("""
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
                  SOURCE: app/views/players.scala.html
                  HASH: 7eaab86e41cc381d931882e5797caecf47d0eb83
                  MATRIX: 724->1|820->4|847->6|870->21|909->23|940->29|987->68|1037->81|1073->91|1305->296|1341->311|1386->328|1464->380|1499->394|1535->400
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|28->4|28->4|30->6|36->12|36->12|37->13|40->16|40->16|41->17
                  -- GENERATED --
              */
          