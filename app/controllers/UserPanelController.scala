package controllers

import models.User

import javax.inject._
import play.api.mvc._

@Singleton
class UserPanelController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
  def panel(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      val user: Option[User] = Http.HttpRequestHandler.getUsers.find(u => u.username == username)
      Ok(views.html.panel(user))
    }.getOrElse(Redirect(routes.AuthUserController.login()))
  }
}
