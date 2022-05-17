package controllers
import models.{Game, Tournament}
import play.api.data._
import play.api.data.Forms._

import javax.inject._
import play.api.mvc._

import java.util.Date
import java.time.{LocalDateTime, ZoneId}
case class tourData(name:String, place:String,date:Date,teams:Seq[String])
case class gameData(tourID: String, _id:String, result:String,date:LocalDateTime,refereeID:String, scorers:Seq[String])

@Singleton
class TournamentController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
    val tournamentForm: Form[tourData] = Form(mapping("name" -> text,
        "place" -> text, "date" -> date,
        "teams" -> seq(text))(tourData.apply)(tourData.unapply)
    )
    val gameForm: Form[gameData] = Form(mapping(
        "tourID" -> text,
        "_id" -> text,
        "result" -> text, "date" -> localDateTime,
        "refereeID" -> text, "scorers" -> seq(text)
        )(gameData.apply)(gameData.unapply)
    )
    def tournaments(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
        val usernameOption = request.session.get("username")
        usernameOption.map { username =>
            val tournaments = Http.HttpRequestHandler.getTournaments
            val teams = Http.HttpRequestHandler.getTeams
            val refs = Http.HttpRequestHandler.getReferees
            val games = Http.HttpRequestHandler.getGames
            Ok(views.html.tournaments("addTournament")
            (views.html.addTournament(tournamentForm)(teams),
                views.html.addGame(gameForm)(tournaments)(games)(teams)(refs))(tournaments))
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
                val tour = Http.HttpRequestHandler.getTournaments.findLast(el => el._id.nonEmpty).get
                val localDateTime = LocalDateTime.ofInstant(data.date.toInstant, ZoneId.systemDefault())
                for(id <- data.teams){
                    val team = Http.HttpRequestHandler.getTeam(id)
                    team.tournaments = team.tournaments :+ tour._id
                    println(team.tournaments)
                    Http.HttpRequestHandler.updateTeam(team)
                }
                for {(x, idxX) <- data.teams.zipWithIndex
                     (y, idxY) <- data.teams.zipWithIndex
                     if idxX < idxY
                     } {
                    Http.HttpRequestHandler.insertGame(Game("",tour._id,x,y,"",localDateTime,"000000000000000000000000",Seq.empty))
//                    tour.games = tour.games :+ Http.HttpRequestHandler.getGames().findLast(el => el._id.nonEmpty).get._id
                }
                Http.HttpRequestHandler.updateTournament(tour)
                Redirect(routes.TournamentController.tournaments())
            }
        )
    }
    def fillGame(): Action[AnyContent] = Action { implicit request =>
        gameForm.bindFromRequest().fold(
            formWithErrors => {
                println(formWithErrors.errors)
                Redirect(routes.TournamentController.tournaments())
            },
            data =>{
                val game = Http.HttpRequestHandler.getGame(data._id)
                game.result = data.result
                game.date = data.date
                game.refereeID = data.refereeID
                game.scorers = game.scorers
                Http.HttpRequestHandler.updateGame(game)
                Redirect(routes.TournamentController.tournaments())
            }
        )
    }
}
