package controllers
import models.Team
import play.api.data._
import play.api.data.Forms._

import javax.inject._
import play.api.mvc._

@Singleton
class TeamController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
    val teamForm = Form(mapping("_id" -> text, "name" -> text, "coach" -> text,
    "players" -> list(text), "tournaments" -> list(text))(Team.apply)(Team.unapply)
    )
    def teams(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
        val usernameOption = request.session.get("username")
        usernameOption.map { username =>
            Ok(views.html.teams("addTeam")(views.html.addTeam(teamForm)))
        }.getOrElse(Redirect(routes.AuthUserController.login()))
    }
    def addTeam(): Action[AnyContent] = Action { implicit request =>
        Ok(views.html.addTeam(teamForm))
    }
}
