package controllers
import models.{Player, Team}
import play.api.Logger
import play.api.data.Forms._
import play.api.data.Form
import play.api.data.Forms.{mapping, number, text}

import javax.inject._
import play.api.mvc._

import java.util.Date

case class playerData (name:String, surname:String, dateOfBirth:Date, goals:Int, appearances:Int,teamId:String )

@Singleton
class PlayerController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
    val playerForm: Form[playerData] = Form(mapping( "name" -> text, "surname"  -> text,
            "dateOfBirth" -> date, "goals" -> number(0), "appearances" -> number(0),
    "teamId" -> text)(playerData.apply)(playerData.unapply)
    )
    val logger : Logger = Logger(this.getClass)
    def players(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
        val usernameOption = request.session.get("username")
        usernameOption.map { username =>
            val temp : Seq[Player] = Http.HttpRequestHandler.getPlayers
            val team : Seq[Team] = Http.HttpRequestHandler.getTeams
        Ok(views.html.players("addPlayer")(views.html.addPlayer(playerForm)(team))(temp)(team))
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
                    dateOfBirth = data.dateOfBirth, goals = data.goals, appearances = data.appearances, teamId = data.teamId))
                Redirect(routes.PlayerController.players())
            }
        )
    }
}
