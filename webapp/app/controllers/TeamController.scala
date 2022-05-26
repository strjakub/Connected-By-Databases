package controllers
import models.{Coach, Player, Team}
import play.api.data._
import play.api.data.Forms._

import javax.inject._
import play.api.mvc._

case class teamData(name:String, coach:String, players:Seq[String],tournaments:Seq[String])
case class teamEditData(_id: String, name: String, coach: String, playersToDelete: Option[Seq[String]], playersToAdd: Option[Seq[String]])

@Singleton
class TeamController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
    val teamForm: Form[teamData] = Form(mapping("name" -> text, "coach" -> text,
    "players" -> seq(text), "tournaments" -> seq(text))
    (teamData.apply)(teamData.unapply))

    val teamEditForm: Form[teamEditData] = Form(mapping("_id" -> text, "name" -> text, "coach" -> text,
        "playersToDelete" -> optional(seq(text)), "playersToAdd" -> optional(seq(text)))
    (teamEditData.apply)(teamEditData.unapply))

    var wantToEdit: Boolean = false
    var teamToEdit: Option[Team] = None

    def teams(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
        val usernameOption = request.session.get("username")
        usernameOption.map { _ =>
            val teams = Http.HttpRequestHandler.getTeams
            val availableCoaches = Http.HttpRequestHandler.getCoaches.filter(el => !teams.exists(t => t._id == el.teamID))
            val players = Http.HttpRequestHandler.getPlayers.filter(el => !teams.exists(t => t._id == el.teamID))
            val coaches = Http.HttpRequestHandler.getCoaches
            Ok(views.html.teams("addTeam")(views.html.addTeam(teamForm)(players)(availableCoaches))(views.html.empty())(teams)(coaches))
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
                val team = Http.HttpRequestHandler.getTeams.last
                val coach = Http.HttpRequestHandler.getCoach(data.coach)
                coach.teamID = team._id
                Http.HttpRequestHandler.updateCoach(coach)
                for(id <- data.players){
                    val player = Http.HttpRequestHandler.getPlayer(id)
                    player.teamID = team._id
                    Http.HttpRequestHandler.updatePlayer(player)
                }
                Redirect(routes.TeamController.teams())
            }
        )
    }

    def deleteTeam() : Action[AnyContent] = Action { implicit request =>
        val usernameOption = request.session.get("username")
        usernameOption.map { _ =>
            val postVals = request.body.asFormUrlEncoded
            postVals.map { args =>
                val index = args("index").head
                val team = Http.HttpRequestHandler.getTeam(index)
                val tournaments = Http.HttpRequestHandler.getTournaments.filter(el => el.teams.contains(index))
                val players = Http.HttpRequestHandler.getPlayers.filter(el => el.teamID == index)
                for(tour <- tournaments){
                    var gamesToRemove:Seq[String] = Seq.empty
                    for(gameID <- tour.games){
                        val game = Http.HttpRequestHandler.getGame(gameID)
                        if(game.team1ID == index ||game.team2ID == index){
                            Http.HttpRequestHandler.deleteGame(game)
                            gamesToRemove = gamesToRemove :+ gameID
                        }
                    }
                    tour.games = tour.games.diff(gamesToRemove)
                    Http.HttpRequestHandler.updateTournament(tour)
                }
                for(player <- players){
                    player.teamID = "000000000000000000000000"
                    Http.HttpRequestHandler.updatePlayer(player)
                }
                val coaches = Http.HttpRequestHandler.getCoaches.filter(el => el.teamID == index)
                for(coach <- coaches){
                    coach.teamID = "000000000000000000000000"
                    Http.HttpRequestHandler.updateCoach(coach)
                }
                Http.HttpRequestHandler.deleteTeam(team)
                Redirect(routes.TeamController.teams())
            }.getOrElse(Redirect(routes.TeamController.teams()))
        }.getOrElse(Redirect(routes.AuthUserController.login()))
    }

    def editTeam(): Action[AnyContent] = Action { implicit request =>
        val usernameOption = request.session.get("username")
        usernameOption.map { _ =>
            val postVals = request.body.asFormUrlEncoded
            postVals.map { args =>
                val index = args("index").head
                val team = Http.HttpRequestHandler.getTeam(index)
                teamToEdit = Some(team)
                wantToEdit = true

                val teams = Http.HttpRequestHandler.getTeams
                val availableCoaches = Http.HttpRequestHandler.getCoaches.filter(el => !teams.exists(t => t._id == el.teamID))
                val players = Http.HttpRequestHandler.getPlayers
                val playersToAdd = players.filter(el => !teams.exists(t => t._id == el.teamID))
                val playersToRemove = players.filter(el => el.teamID == team._id)
                val coaches = Http.HttpRequestHandler.getCoaches

                Ok(views.html.teams("addTeam")(views.html.addTeam(teamForm)(players)(availableCoaches))(views.html.editTeam(teamEditForm)(teamToEdit)(playersToRemove)(playersToAdd)(coaches)(wantToEdit))(teams)(coaches))
            }.getOrElse(Redirect(routes.TeamController.teams()))
        }.getOrElse(Redirect(routes.AuthUserController.login()))
    }

    def edit(): Action[AnyContent] = Action { implicit request =>
        teamEditForm.bindFromRequest().fold(
            formWithErrors => {
                println(formWithErrors.errors)
                Redirect(routes.TournamentController.tournaments())
            },
            data =>{
                val teamToUpdate: Team = Http.HttpRequestHandler.getTeam(data._id)
                val oldCoach: Coach = Http.HttpRequestHandler.getCoach(teamToUpdate.coach)
                val newCoach: Coach = Http.HttpRequestHandler.getCoach(data.coach)

                // Update team
                teamToUpdate.name = data.name

                var newTeamPlayers: Seq[String] = List()
                // Remove players
                data.playersToDelete match {
                    case Some(players) =>
                        // New team player's list
                        for(id <- teamToUpdate.players){
                            if(!players.contains(id)){
                                newTeamPlayers = newTeamPlayers :+ id
                            }
                        }
                        for(id <- players) {
                            // Remove team from player
                            val player: Player = Http.HttpRequestHandler.getPlayer(id)
                            player.teamID = "000000000000000000000000"
                            Http.HttpRequestHandler.updatePlayer(player)
                        }
                    case None =>
                }

                teamToUpdate.players = newTeamPlayers
                // Add new players
                data.playersToAdd match {
                    case Some(players) =>
                        for(id <-  players){
                            // Add player to team
                            teamToUpdate.players = teamToUpdate.players :+ id

                            // Add team to player
                            val player: Player = Http.HttpRequestHandler.getPlayer(id)
                            player.teamID = teamToUpdate._id
                            Http.HttpRequestHandler.updatePlayer(player)
                        }
                    case None =>
                }

                // Previous coach is now without a team
                oldCoach.teamID = "000000000000000000000000"
                Http.HttpRequestHandler.updateCoach(oldCoach)

                // New coach
                newCoach.teamID = data._id
                Http.HttpRequestHandler.updateCoach(newCoach)

                // Update coach
                teamToUpdate.coach = newCoach._id

                Http.HttpRequestHandler.updateTeam(teamToUpdate)

                Redirect(routes.TeamController.teams())
            }
        )
    }
}
