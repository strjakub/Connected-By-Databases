package controllers
import play.api.data._
import play.api.data.Forms._

import javax.inject._
import play.api.mvc._

case class teamData(name:String, coach:String, players:List[String],tournaments:List[String])

@Singleton
class TeamController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
    val teamForm: Form[teamData] = Form(mapping("name" -> text, "coach" -> text,
    "players" -> list(text), "tournaments" -> list(text))(teamData.apply)(teamData.unapply)
    )
    def teams(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
        val usernameOption = request.session.get("username")
        usernameOption.map { username =>
            Ok(views.html.teams("addTeam")(views.html.addTeam(teamForm)))
        }.getOrElse(Redirect(routes.AuthUserController.login()))
    }
    def addTeam(): Action[AnyContent] = Action { implicit request =>
        teamForm.bindFromRequest().fold(
            formWithErrors => {
                println(formWithErrors.errors)
                Redirect(routes.PlayerController.players())
            },
            data =>{
                println(data)
                Redirect(routes.PlayerController.players())
            }
        )
    }
}
