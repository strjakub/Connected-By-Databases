
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

object home extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/main("Home page")/*3.19*/ {_display_(Seq[Any](format.raw/*3.21*/("""
  """),_display_(/*4.4*/defining(play.core.PlayVersion.current)/*4.43*/ { version =>_display_(Seq[Any](format.raw/*4.56*/("""

  """),format.raw/*6.3*/("""<section id="content">
    <div class="wrapper doc">
      <article>
        <!-- CONTENT HERE -->
      </article>
      <aside>
        """),_display_(/*12.10*/commonSidebar()),format.raw/*12.25*/("""
      """),format.raw/*13.7*/("""</aside>
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
                  SOURCE: app/views/home.scala.html
                  HASH: e2a019b053327ec9227243171183db5a8f5ceef6
                  MATRIX: 721->1|817->3|847->8|872->25|911->27|941->32|988->71|1038->84|1070->90|1242->235|1278->250|1313->258|1378->297|1413->311|1448->316
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|29->4|29->4|31->6|37->12|37->12|38->13|41->16|41->16|42->17
                  -- GENERATED --
              */
          