package controllers
import models.Team
import play.api.data._
import play.api.data.Forms._

import javax.inject._
import play.api.mvc._

case class teamData(name:String, coach:String, players:Seq[String],tournaments:Seq[String])

@Singleton
class TeamController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
    val teamForm: Form[teamData] = Form(mapping("name" -> text, "coach" -> text,
    "players" -> seq(text), "tournaments" -> seq(text))(teamData.apply)(teamData.unapply)
    )
    def teams(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
        val usernameOption = request.session.get("username")
        usernameOption.map { username =>
            val teams = Http.HttpRequestHandler.getTeams()
            val availableCoaches = Http.HttpRequestHandler.getCoaches().filter(el => !teams.exists(t => t._id == el.teamID))
            val players = Http.HttpRequestHandler.getPlayers().filter(el => !teams.exists(t => t._id == el.teamId))
            val coaches = Http.HttpRequestHandler.getCoaches()
            Ok(views.html.teams("addTeam")(views.html.addTeam(teamForm)(players)(availableCoaches))(teams)(coaches))
        }.getOrElse(Redirect(routes.AuthUserController.login()))
    }
    def addTeam(): Action[AnyContent] = Action { implicit request =>
        teamForm.bindFromRequest().fold(
            formWithErrors => {
                println(formWithErrors.errors)
                Redirect(routes.TeamController.teams())
            },
            data =>{
                Http.HttpRequestHandler.insertTeam(Team("", data.name, data.coach, data.players, Seq.empty))
                val team = Http.HttpRequestHandler.getTeams().findLast(el => el._id.nonEmpty).get
                val hello = Http.HttpRequestHandler.getCoach(data.coach)
                hello.teamID = team._id
                Http.HttpRequestHandler.updateCoach(hello)
                for(id <- data.players){
                    val player = Http.HttpRequestHandler.getPlayer(id)
                    player.teamId = team._id
                    Http.HttpRequestHandler.updatePlayer(player)
                }

                Redirect(routes.TeamController.teams())
            }
        )
    }
}
