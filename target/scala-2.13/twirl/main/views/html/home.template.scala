
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
        <p>HOME CONTENT HERE</p>
      </article>
      <aside>
        """),_display_(/*13.10*/commonSidebar()),format.raw/*13.25*/("""
      """),format.raw/*14.7*/("""</aside>
    </div>
  </section>
  """),_display_(/*17.4*/commonFooter()),format.raw/*17.18*/("""
  """)))}),format.raw/*18.4*/("""
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
                  HASH: 3eeb2797b212a13a52316ccd47338be37360f92f
                  MATRIX: 721->1|817->3|847->8|872->25|911->27|941->32|988->71|1038->84|1070->90|1276->269|1312->284|1347->292|1412->331|1447->345|1482->350
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|29->4|29->4|31->6|38->13|38->13|39->14|42->17|42->17|43->18
                  -- GENERATED --
              */
          