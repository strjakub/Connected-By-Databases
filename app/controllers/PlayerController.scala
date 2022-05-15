package controllers
import models.Player
import play.api.data.Forms._
import play.api.data.Form
import play.api.data.Forms.{mapping, number, optional, text}

import javax.inject._
import play.api.mvc._

@Singleton
class PlayerController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
    val playerForm: Form[Player] = Form(mapping("name" -> text, "surname"  -> text,
            "dateOfBrith" -> date, "goals" -> number(0), "appearances" -> number(0),
    "teamId" -> optional(text))(Player.apply)(Player.unapply)
            )
    def players(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
        val usernameOption = request.session.get("username")
        usernameOption.map { username =>
        Ok(views.html.players("addPlayer")(views.html.addPlayer(playerForm)))
        }.getOrElse(Redirect(routes.AuthUserController.login()))
    }
    def addPlayer(): Action[AnyContent] = Action { implicit request =>
        Ok(views.html.addPlayer(playerForm))
    }
}
