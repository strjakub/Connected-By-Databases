package controllers

import javax.inject._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import java.util.{Calendar, GregorianCalendar}

case class sortScorersData(value: Int)

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{

  var currentSortedScorers: Int = 1

  val sortScorersForm: Form[sortScorersData] = Form(mapping("value" -> number)
  (sortScorersData.apply)(sortScorersData.unapply))

  def home(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val usernameOption = request.session.get("username")
    usernameOption.map { _ =>

      val players = Http.HttpRequestHandler.getPlayersSortedByGoals(currentSortedScorers)
      val teams = Http.HttpRequestHandler.getTeams
      val games = Http.HttpRequestHandler.getIncomingGames(Calendar.getInstance().getTime, new GregorianCalendar(3000,12,28).getTime)
      val tournaments = Http.HttpRequestHandler.getIncomingTournaments(Calendar.getInstance().getTime, new GregorianCalendar(3000,12,28).getTime)

      Ok(views.html.home(sortScorersForm)(currentSortedScorers)(players)(teams)(games)(tournaments))
    }.getOrElse(Redirect(routes.AuthUserController.login()))
  }

  def sortScorers(): Action[AnyContent] = Action { implicit request =>
    sortScorersForm.bindFromRequest().fold(
      formWithErrors => {
        println(formWithErrors.errors)
        Redirect(routes.HomeController.home())
      },
      data =>{

        currentSortedScorers = if (data.value >=0) data.value else 5

        val players = Http.HttpRequestHandler.getPlayersSortedByGoals(currentSortedScorers)
        val teams = Http.HttpRequestHandler.getTeams
        val games = Http.HttpRequestHandler.getIncomingGames(Calendar.getInstance().getTime, new GregorianCalendar(3000,12,28).getTime)
        val tournaments = Http.HttpRequestHandler.getIncomingTournaments(Calendar.getInstance().getTime, new GregorianCalendar(3000,12,28).getTime)

        Ok(views.html.home(sortScorersForm)(currentSortedScorers)(players)(teams)(games)(tournaments))
      }
    )
  }

}
