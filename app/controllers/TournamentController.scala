package controllers
import models.{Game, Tournament}
import play.api.data._
import play.api.data.Forms._

import javax.inject._
import play.api.mvc._

import java.text.SimpleDateFormat
import java.util.Date
import java.time.LocalDateTime
case class tourData(name:String, place:String,date:Date,teams:Seq[String])

@Singleton
class TournamentController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
    val tournamentForm: Form[tourData] = Form(mapping("name" -> text,
        "place" -> text, "date" -> date,
        "teams" -> seq(text))(tourData.apply)(tourData.unapply)
    )
    def tournaments(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
        val usernameOption = request.session.get("username")
        usernameOption.map { username =>
            val tournaments = Http.HttpRequestHandler.getTournaments
            val teams = Http.HttpRequestHandler.getTeams
            val refs = Http.HttpRequestHandler.getReferees
            val games = Http.HttpRequestHandler.getGames
            val players = Http.HttpRequestHandler.getPlayers
            Ok(views.html.tournaments("addTournament")(views.html.addTournament(tournamentForm)(teams))(tournaments)(teams)(games))
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
                val tour = Http.HttpRequestHandler.getTournaments.last
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
                    Http.HttpRequestHandler.insertGame(Game("",tour._id,x,y,"---",data.date,"000000000000000000000000",Seq.empty))
                    tour.games = tour.games :+ Http.HttpRequestHandler.getGames.last._id
                }
                Http.HttpRequestHandler.updateTournament(tour)
                Redirect(routes.TournamentController.tournaments())
            }
        )
    }

    def fillGame():Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
        val postVals = request.body.asFormUrlEncoded 
        postVals.map { args =>
            val game = Http.HttpRequestHandler.getGame(args("_id").head)
            val tour = Http.HttpRequestHandler.getTournaments.find(el => el.games.contains(args("_id").head))

            val game_id: String = args("_id").head 
            val game_result: String = args("result").head 
            val game_Date: String = args("date").head 
            val game_refereeID: String = args("refereeID").head 

            val game_scorers: Seq[String] = Seq() 
            if(args.contains("scorers[]")){
                game_scorers :++ args("scorers[]")
            }
            val dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
            val d: Date = dateFormat.parse(game_Date)

            game.result = game_result
            game.date = d 
            game.refereeID = game_refereeID
            game.scorers = game_scorers
            
            Http.HttpRequestHandler.updateGame(game)

            Redirect(routes.TournamentController.show(args("tournamentID").head))
        }.getOrElse(Redirect(routes.AuthUserController.login()))
    }

    def showTournamentPage: Action[AnyContent] = Action { implicit request =>
        val usernameOption = request.session.get("username")
        usernameOption.map { username =>
            val postVals = request.body.asFormUrlEncoded
            postVals.map { args => 
                val index = args("index").head
                Redirect(routes.TournamentController.show(index))
            }.getOrElse(Redirect(routes.TournamentController.tournaments()))
        }.getOrElse(Redirect(routes.AuthUserController.login()))
    }

    def show(tournamentID: String): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
        val tournament: Tournament = Http.HttpRequestHandler.getTournament(tournamentID)
        val games: Seq[Game] = Http.HttpRequestHandler.getGames.filter( el => el.tourID ==  tournamentID)
        val teams = Http.HttpRequestHandler.getTeams
        val players = Http.HttpRequestHandler.getPlayers
        val refs = Http.HttpRequestHandler.getReferees
        Ok(views.html.tournamentInfo(tournament)(games)(teams)(players)(refs))
    }
}
