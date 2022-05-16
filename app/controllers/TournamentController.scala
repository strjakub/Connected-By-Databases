package controllers
import models.Tournament
import play.api.data._
import play.api.data.Forms._

import javax.inject._
import play.api.mvc._
import java.util.Date
import java.time.LocalDateTime
case class tourData(name:String, place:String,date:Date,teams:Seq[String],games:Seq[String])
case class gameData(tourID: String, team1Id:String, team2Id:String,result:String,date:LocalDateTime,refereeId:String, scorers:Seq[String])

@Singleton
class TournamentController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
    val tournamentForm: Form[tourData] = Form(mapping("name" -> text,
        "place" -> text, "date" -> date,
        "teams" -> seq(text), "games" -> seq(text)
        )(tourData.apply)(tourData.unapply)
    )
    val gameForm: Form[gameData] = Form(mapping(
            "tourID" -> text,
        "team1Id" -> text, "team2Id" -> text,
        "result" -> text, "date" -> localDateTime,
        "refereeId" -> text, "scorers" -> seq(text)
        )(gameData.apply)(gameData.unapply)
    )
    def tournaments(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
        val usernameOption = request.session.get("username")
        usernameOption.map { username =>
            val tournaments = Http.HttpRequestHandler.getTournaments()
            val teams = Http.HttpRequestHandler.getTeams()
            Ok(views.html.tournaments("addTournament")
            (views.html.addTournament(tournamentForm)(teams),
                views.html.addGame(gameForm)(tournaments)(teams))(tournaments))
        }.getOrElse(Redirect(routes.AuthUserController.login()))
    }
    def addTournament(): Action[AnyContent] = Action { implicit request =>
        tournamentForm.bindFromRequest().fold(
            formWithErrors => {
                println(formWithErrors.errors)
                Redirect(routes.TournamentController.tournaments())
            },
            data =>{
                Http.HttpRequestHandler.insertTournament(Tournament("", data.name,data.place, data.date, data.teams,Seq.empty))
                val tour = Http.HttpRequestHandler.getTournaments().findLast(el => el._id.nonEmpty).get
                for(id <- data.teams){
                    val team = Http.HttpRequestHandler.getTeam(id)
                    team.tournaments :+ tour._id
                    Http.HttpRequestHandler.updateTeam(team)
                }

                Redirect(routes.TournamentController.tournaments())
            }
        )
    }
    def addGame(): Action[AnyContent] = Action { implicit request =>
        gameForm.bindFromRequest().fold(
            formWithErrors => {
                println(formWithErrors.errors)
                Redirect(routes.TournamentController.tournaments())
            },
            data =>{
                Http.HttpRequestHandler.insertTournament(Tournament("", data.,data.place, data.date, data.teams,Seq.empty))
                val tour = Http.HttpRequestHandler.getTournaments().findLast(el => el._id.nonEmpty).get
                for(id <- data.teams){
                    val team = Http.HttpRequestHandler.getTeam(id)
                    team.tournaments :+ tour._id
                    Http.HttpRequestHandler.updateTeam(team)
                }

                Redirect(routes.TournamentController.tournaments())
            }
        )
    }
}
