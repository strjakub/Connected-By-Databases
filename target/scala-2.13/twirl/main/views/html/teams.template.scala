
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

object teams extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/main("Teams")/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/("""
    """),_display_(/*4.6*/defining(play.core.PlayVersion.current)/*4.45*/ { version =>_display_(Seq[Any](format.raw/*4.58*/("""

        """),format.raw/*6.9*/("""<section id="content">
            <div class="wrapper doc">
                <article>
                        <!-- CONTENT HERE -->
                    <p>TEAMS INFO HERE</p>
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
                  SOURCE: app/views/teams.scala.html
                  HASH: 8529dab18fab0450441b38fc98591d9a9146c364
                  MATRIX: 722->1|818->3|848->8|869->21|908->23|940->30|987->69|1037->82|1075->94|1357->349|1393->364|1439->382|1520->437|1555->451|1592->458
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|29->4|29->4|31->6|38->13|38->13|39->14|42->17|42->17|43->18
                  -- GENERATED --
              */
          