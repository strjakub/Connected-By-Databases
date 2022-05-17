package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
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
