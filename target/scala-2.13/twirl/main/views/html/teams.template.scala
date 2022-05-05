
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
                  SOURCE: app/views/teams.scala.html
                  HASH: 0ffd49ee7300ae0242f2ad03c8b7152cc7e4e6a2
                  MATRIX: 722->1|818->3|848->8|869->21|908->23|940->30|987->69|1037->82|1075->94|1313->305|1349->320|1395->338|1476->393|1511->407|1548->414
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|29->4|29->4|31->6|37->12|37->12|38->13|41->16|41->16|42->17
                  -- GENERATED --
              */
          