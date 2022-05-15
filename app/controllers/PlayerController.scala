package controllers
import models.Player
import play.api.data._
import play.api.data.Forms._
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

import javax.inject.Inject

class PlayerController @Inject() (cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport{
    val playerForm: Form[Player] = Form(mapping("name" -> text, "surname"  -> text,
      "dateOfBrith" -> date, "goals" -> number(0), "appearances" -> number(0),
      "teamId" -> optional(text))(Player.apply)(Player.unapply)
    )

    def index: Action[AnyContent] = Action { implicit request =>
        Ok(views.html.addPlayer(playerForm))
    }
}
