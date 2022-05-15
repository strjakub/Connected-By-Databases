package controllers
import models.Player
import play.api.data.Forms._
import play.api.data.Form
import play.api.data.Forms.{mapping, number, optional, text}

import javax.inject._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

  def home(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      Ok(views.html.home())
    }.getOrElse(Redirect(routes.AuthUserController.login()))
  }

  def panel(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      Ok(views.html.panel())
    }.getOrElse(Redirect(routes.AuthUserController.login()))
  }
}
