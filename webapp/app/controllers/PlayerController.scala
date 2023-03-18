package controllers
import models.{Player, Team}
import play.api.Logger
import play.api.data.Forms._
import play.api.data.Form
import play.api.data.Forms.{mapping, number, text}

import javax.inject._
import play.api.mvc._

import java.util.Date

case class playerData (name:String, surname:String, dateOfBirth:Date, goals:Int, appearances:Int,teamID:String )
case class playerToEditData (_id: String, name:String, surname:String, goals:Int, appearances:Int,teamID:String )

@Singleton
class PlayerController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
    val playerForm: Form[playerData] = Form(mapping( "name" -> text, "surname"  -> text,
            "dateOfBirth" -> date, "goals" -> number(0), "appearances" -> number(0),
    "teamID" -> text)(playerData.apply)(playerData.unapply)
    )

    val playerToEditForm: Form[playerToEditData] = Form(mapping( "_id" -> text ,"name" -> text, "surname"  -> text,
         "goals" -> number(0), "appearances" -> number(0),
        "teamID" -> text)(playerToEditData.apply)(playerToEditData.unapply)
    )

    var playerToEdit: Option[Player] = None

    val logger : Logger = Logger(this.getClass)

    var wantToEdit: Boolean = false

    def players(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
        val usernameOption = request.session.get("username")
        usernameOption.map { _ =>
            val temp : Seq[Player] = Http.HttpRequestHandler.getPlayers
            val team : Seq[Team] = Http.HttpRequestHandler.getTeams
            wantToEdit = false
            Ok(views.html.players("addPlayer")(views.html.addPlayer(playerForm)(team))(views.html.empty())(temp)(team))
        }.getOrElse(Redirect(routes.AuthUserController.login()))
    }

    def addPlayer(): Action[AnyContent] = Action { implicit request =>
        playerForm.bindFromRequest().fold(
            formWithErrors => {
                println(formWithErrors.errors)
                Redirect(routes.PlayerController.players())
            },
            data =>{
                Http.HttpRequestHandler.insertPlayer(Player("", data.name, data.surname,
                    dateOfBirth = data.dateOfBirth, goals = data.goals, appearances = data.appearances, teamID = data.teamID))
                Redirect(routes.PlayerController.players())
            }
        )
    }

    def deletePlayer(): Action[AnyContent] = Action { implicit request =>
        val usernameOption = request.session.get("username")
        usernameOption.map { _ =>
            val postVals = request.body.asFormUrlEncoded
            postVals.map { args =>
                val index = args("index").head
                val player = Http.HttpRequestHandler.getPlayer(index)
                if(player.teamID != "000000000000000000000000") {
                    val games = Http.HttpRequestHandler.getGames.filter(el => el.scorers.contains(index))
                    val team = Http.HttpRequestHandler.getTeam(player.teamID)
                    for (game <- games) {
                        game.scorers = game.scorers diff Seq(index)
                        Http.HttpRequestHandler.updateGame(game)
                    }
                    team.players = team.players diff Seq(index)
                    Http.HttpRequestHandler.updateTeam(team)
                }
                Http.HttpRequestHandler.deletePlayer(player)
                Redirect(routes.PlayerController.players())
            }.getOrElse(Redirect(routes.PlayerController.players()))
        }.getOrElse(Redirect(routes.AuthUserController.login()))
    }

    def editPlayer(): Action[AnyContent] = Action { implicit request =>
        val usernameOption = request.session.get("username")
        usernameOption.map { _ =>
            val postVals = request.body.asFormUrlEncoded
            postVals.map { args =>
                val index = args("index").head
                val player = Http.HttpRequestHandler.getPlayer(index)
                playerToEdit = Some(player)
                wantToEdit = true
                val temp : Seq[Player] = Http.HttpRequestHandler.getPlayers
                val team : Seq[Team] = Http.HttpRequestHandler.getTeams
                Ok(views.html.players("addPlayer")(views.html.addPlayer(playerForm)(team))(views.html.editPlayer(playerToEditForm)(playerToEdit)(wantToEdit)(team))(temp)(team))
            }.getOrElse(Redirect(routes.PlayerController.players()))
        }.getOrElse(Redirect(routes.AuthUserController.login()))
    }

    def edit(): Action[AnyContent] = Action { implicit request =>
        playerToEditForm.bindFromRequest().fold(
            formWithErrors => {
                println(formWithErrors.errors)
                Redirect(routes.PlayerController.players())
            },
            data =>{
                val playerToUpdate: Player = Http.HttpRequestHandler.getPlayer(data._id)
                playerToUpdate.name = data.name
                playerToUpdate.surname = data.surname
                playerToUpdate.teamID = data.teamID
                playerToUpdate.goals = data.goals
                playerToUpdate.appearances = data.appearances
                Http.HttpRequestHandler.updatePlayer(playerToUpdate)
                Redirect(routes.PlayerController.players())
            }
        )
    }
}
