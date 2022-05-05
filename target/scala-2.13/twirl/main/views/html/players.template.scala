
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
                    <p>PLAYERS INFO HERE</p>
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
                  SOURCE: app/views/players.scala.html
                  HASH: 8ec25e37abea0248984a8fea7b72e76f1c838205
                  MATRIX: 724->1|820->4|847->6|870->21|909->23|940->29|987->68|1037->81|1073->91|1350->341|1386->356|1431->373|1509->425|1544->439|1580->445
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|28->4|28->4|30->6|37->13|37->13|38->14|41->17|41->17|42->18
                  -- GENERATED --
              */
          