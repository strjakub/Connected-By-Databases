
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

object register extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[RequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request: RequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/outmain("Login")/*3.18*/ {_display_(Seq[Any](format.raw/*3.20*/("""
    """),_display_(/*4.6*/defining(play.core.PlayVersion.current)/*4.45*/ { version =>_display_(Seq[Any](format.raw/*4.58*/("""
        """),format.raw/*5.9*/("""<div class="wrapper">
            <article>
                <form method="post" action=""""),_display_(/*7.46*/routes/*7.52*/.AuthUserController.createUser()),format.raw/*7.84*/("""">
                        <!-- Add in to our form a CSRF token -->
                    """),_display_(/*9.22*/helper/*9.28*/.CSRF.formField),format.raw/*9.43*/("""
                    """),format.raw/*10.21*/("""<h3>REGISTER</h3>
                    <h4>Username:</h4>
                    <label>
                        <input type="text" name="username">
                    </label>
                    <h4>Password:</h4>
                    <label>
                        <input type="password" name="password">
                    </label>
                    <input type="submit" value="Submit">
                </form>
                <p class="auth-link"><a href=""""),_display_(/*21.48*/routes/*21.54*/.AuthUserController.login()),format.raw/*21.81*/("""">LOGIN</a></p>
            </article>
        </div>
    """)))}),format.raw/*24.6*/("""
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
                  SOURCE: app/views/register.scala.html
                  HASH: a80ca232997db43ec72caa3022f111380a4e6b1b
                  MATRIX: 745->1|888->51|915->53|939->69|978->71|1009->77|1056->116|1106->129|1141->138|1256->227|1270->233|1322->265|1437->354|1451->360|1486->375|1535->396|2024->858|2039->864|2087->891|2176->950
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|28->4|28->4|29->5|31->7|31->7|31->7|33->9|33->9|33->9|34->10|45->21|45->21|45->21|48->24
                  -- GENERATED --
              */
          