package controllers
import models.Player
import play.api.Logger
import play.api.data.Forms._
import play.api.data.Form
import play.api.data.Forms.{mapping, number, optional, text}

import javax.inject._
import play.api.mvc._

import java.util.Date

case class playerData (name:String, surname:String, dateOfBirth:Date, goals:Int, appearances:Int,teamId:Option[String] )

@Singleton
class PlayerController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
    val playerForm: Form[playerData] = Form(mapping( "name" -> text, "surname"  -> text,
            "dateOfBirth" -> date, "goals" -> number(0), "appearances" -> number(0),
    "teamId" -> optional(text))(playerData.apply)(playerData.unapply)
    )
    val logger : Logger = Logger(this.getClass)
    def players(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
        val usernameOption = request.session.get("username")
        usernameOption.map { username =>
        Ok(views.html.players("addPlayer")(views.html.addPlayer(playerForm)))
        }.getOrElse(Redirect(routes.AuthUserController.login()))
    }
    def addPlayer(): Action[AnyContent] = Action { implicit request =>
        playerForm.bindFromRequest().fold(
            formWithErrors => {
                println(formWithErrors.errors)
                Redirect(routes.PlayerController.players())
            },
            data =>{
                println("Success")
                Redirect(routes.PlayerController.players())
            }
        )
    }
}
