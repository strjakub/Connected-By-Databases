package controllers

import javax.inject._
import play.api.mvc._

import java.util.Calendar
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
  def home(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      val players = Http.HttpRequestHandler.getPlayers.sortBy(el => el.goals)(Ordering[Int].reverse).take(5)
      val teams = Http.HttpRequestHandler.getTeams
      val now = Calendar.getInstance().getTime
      val games = Http.HttpRequestHandler.getGames.filter(el => el.date.after(now)).sortBy(el => el.date).take(5)
      Ok(views.html.home()(players)(teams)(games))
    }.getOrElse(Redirect(routes.AuthUserController.login()))
  }
}
