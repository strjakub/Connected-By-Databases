
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

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[RequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request: RequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/outmain("Login")/*3.18*/ {_display_(Seq[Any](format.raw/*3.20*/("""
    """),_display_(/*4.6*/defining(play.core.PlayVersion.current)/*4.45*/ { version =>_display_(Seq[Any](format.raw/*4.58*/("""
        """),format.raw/*5.9*/("""<div class="wrapper">
            <article>
                <form method="post" action=""""),_display_(/*7.46*/routes/*7.52*/.AuthUserController.validateLoginPost()),format.raw/*7.91*/("""">
                        <!-- Add in to our form a CSRF token -->
                    """),_display_(/*9.22*/helper/*9.28*/.CSRF.formField),format.raw/*9.43*/("""
                    """),format.raw/*10.21*/("""<h3>LOGIN</h3>
                    <h4>Username: </h4>
                    <input type="text" name="username">
                    <h4>Password:</h4>
                    <input type="password" name="password">
                    <input id="submitButton"  type="submit" value="Submit">
                </form>
                <p class="auth-link"><a href=""""),_display_(/*17.48*/routes/*17.54*/.AuthUserController.register()),format.raw/*17.84*/("""">REGISTER</a></p>
            </article>
        </div>
    """)))}),format.raw/*20.6*/("""
""")))}))
      }
    }
  }

  def render(request:RequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply()(request,flash)

  def f:(() => (RequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = () => (request,flash) => apply()(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/login.scala.html
                  HASH: 2a4fc664a12de15cc747dab58a7cd403acf47157
                  MATRIX: 742->1|885->51|912->53|936->69|975->71|1006->77|1053->116|1103->129|1138->138|1253->227|1267->233|1326->272|1441->361|1455->367|1490->382|1539->403|1923->760|1938->766|1989->796|2081->858
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|28->4|28->4|29->5|31->7|31->7|31->7|33->9|33->9|33->9|34->10|41->17|41->17|41->17|44->20
                  -- GENERATED --
              */
          