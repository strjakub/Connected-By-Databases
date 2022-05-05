
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

object tournaments extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/main("Tournaments")/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
  """),_display_(/*4.4*/defining(play.core.PlayVersion.current)/*4.43*/ { version =>_display_(Seq[Any](format.raw/*4.56*/("""

    """),format.raw/*6.5*/("""<section id="content">
      <div class="wrapper doc">
        <article>
            <!-- CONTENT HERE -->
        </article>
        <aside>
          """),_display_(/*12.12*/commonSidebar()),format.raw/*12.27*/("""
        """),format.raw/*13.9*/("""</aside>
      </div>
    </section>
  """),_display_(/*16.4*/commonFooter()),format.raw/*16.18*/("""
  """)))}),format.raw/*17.4*/("""
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
                  SOURCE: app/views/tournaments.scala.html
                  HASH: a8edbf35b824dbaa54a7dbed04a79d3826f33837
                  MATRIX: 728->1|824->3|854->8|881->27|920->29|950->34|997->73|1047->86|1081->94|1267->253|1303->268|1340->278|1409->321|1444->335|1479->340
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|29->4|29->4|31->6|37->12|37->12|38->13|41->16|41->16|42->17
                  -- GENERATED --
              */
          