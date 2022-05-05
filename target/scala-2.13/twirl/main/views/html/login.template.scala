
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

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/outmain("Login")/*3.18*/ {_display_(Seq[Any](format.raw/*3.20*/("""
    """),_display_(/*4.6*/defining(play.core.PlayVersion.current)/*4.45*/ { version =>_display_(Seq[Any](format.raw/*4.58*/("""
        """),format.raw/*5.9*/("""<div class="wrapper">
            <article>
                <form method="post" action=""""),_display_(/*7.46*/routes/*7.52*/.AuthUserController.validateLoginPost()),format.raw/*7.91*/("""">
                    <h3>LOGIN</h3>
                    Username: <input type="text" name="username">
                    Password: <input type="password" name="password">
                    <input type="submit">
                </form>
                <p class="auth-link"><a href=""""),_display_(/*13.48*/routes/*13.54*/.AuthUserController.register()),format.raw/*13.84*/("""">REGISTER</a></p>
            </article>
        </div>
    """)))}),format.raw/*16.6*/("""
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
                  SOURCE: app/views/login.scala.html
                  HASH: 5bb915f097cb0a9a159abcf1dd6c0e5c440d7ffb
                  MATRIX: 722->1|818->3|848->8|872->24|911->26|943->33|990->72|1040->85|1076->95|1193->186|1207->192|1266->231|1586->524|1601->530|1652->560|1747->625
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|29->4|29->4|30->5|32->7|32->7|32->7|38->13|38->13|38->13|41->16
                  -- GENERATED --
              */
          