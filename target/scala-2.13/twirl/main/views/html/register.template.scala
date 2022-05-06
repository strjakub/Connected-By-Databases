
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

object register extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.37*/("""

"""),_display_(/*3.2*/outmain("Login")/*3.18*/ {_display_(Seq[Any](format.raw/*3.20*/("""
    """),_display_(/*4.6*/defining(play.core.PlayVersion.current)/*4.45*/ { version =>_display_(Seq[Any](format.raw/*4.58*/("""
        """),format.raw/*5.9*/("""<div class="wrapper">
            <article>
                <form method="post" action=""""),_display_(/*7.46*/routes/*7.52*/.AuthUserController.createUser()),format.raw/*7.84*/("""">
                        <!-- Add in to our form a CSRF token -->
                    """),_display_(/*9.22*/helper/*9.28*/.CSRF.formField),format.raw/*9.43*/("""
                    """),format.raw/*10.21*/("""<h3>REGISTER</h3>
                    Username: <input type="text" name="username">
                    Password: <input type="password" name="password">
                    <input type="submit" value="Submit">
                </form>
                <p class="auth-link"><a href=""""),_display_(/*15.48*/routes/*15.54*/.AuthUserController.login()),format.raw/*15.81*/("""">LOGIN</a></p>
            </article>
        </div>
    """)))}),format.raw/*18.6*/("""
""")))}))
      }
    }
  }

  def render(request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply()(request)

  def f:(() => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = () => (request) => apply()(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/register.scala.html
                  HASH: 70b918997c4eb8301fa4b89349faf3d4192a4ee5
                  MATRIX: 739->1|869->36|899->41|923->57|962->59|994->66|1041->105|1091->118|1127->128|1244->219|1258->225|1310->257|1427->348|1441->354|1476->369|1526->391|1840->678|1855->684|1903->711|1995->773
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|29->4|29->4|30->5|32->7|32->7|32->7|34->9|34->9|34->9|35->10|40->15|40->15|40->15|43->18
                  -- GENERATED --
              */
          