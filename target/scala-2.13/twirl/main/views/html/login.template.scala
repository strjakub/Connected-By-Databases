
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

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.37*/("""

"""),_display_(/*3.2*/outmain("Login")/*3.18*/ {_display_(Seq[Any](format.raw/*3.20*/("""
    """),_display_(/*4.6*/defining(play.core.PlayVersion.current)/*4.45*/ { version =>_display_(Seq[Any](format.raw/*4.58*/("""
        """),format.raw/*5.9*/("""<div class="wrapper">
            <article>
                <form method="post" action=""""),_display_(/*7.46*/routes/*7.52*/.AuthUserController.validateLoginPost()),format.raw/*7.91*/("""">
                        <!-- Add in to our form a CSRF token -->
                    """),_display_(/*9.22*/helper/*9.28*/.CSRF.formField),format.raw/*9.43*/("""
                    """),format.raw/*10.21*/("""<h3>LOGIN</h3>
                    Username: <input type="text" name="username">
                    Password: <input type="password" name="password">
                    <input type="submit" value="Submit">
                </form>
                <p class="auth-link"><a href=""""),_display_(/*15.48*/routes/*15.54*/.AuthUserController.register()),format.raw/*15.84*/("""">REGISTER</a></p>
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
                  SOURCE: app/views/login.scala.html
                  HASH: 6d546465008984f5cbe6948ceac40a5efa4cd072
                  MATRIX: 736->1|866->36|896->41|920->57|959->59|991->66|1038->105|1088->118|1124->128|1241->219|1255->225|1314->264|1431->355|1445->361|1480->376|1530->398|1841->682|1856->688|1907->718|2002->783
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|29->4|29->4|30->5|32->7|32->7|32->7|34->9|34->9|34->9|35->10|40->15|40->15|40->15|43->18
                  -- GENERATED --
              */
          