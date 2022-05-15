package controllers
import models.{Game, Tournament}
import play.api.data._
import play.api.data.Forms._

import javax.inject._
import play.api.mvc._

@Singleton
class TournamentController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
    val tournamentForm: Form[Tournament] = Form(mapping("name" -> text, "place" -> text,
        "date" -> date, "teams" -> list(text), "games" -> list(text)
        )(Tournament.apply)(Tournament.unapply)
    )
    val gameForm: Form[Game] = Form(mapping(
        "team1Id" -> text, "team2Id" -> text,
        "result" -> text, "date" -> localDateTime,
        "refereeId" -> text, "scorers" -> list(text)
        )(Game.apply)(Game.unapply)
    )
    def tournaments(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
        val usernameOption = request.session.get("username")
        usernameOption.map { username =>
            Ok(views.html.tournaments("addTournament")
            (views.html.addTournament(tournamentForm),
                views.html.addGame(gameForm)))
        }.getOrElse(Redirect(routes.AuthUserController.login()))
    }
    def addTournament(): Action[AnyContent] = Action { implicit request =>
        Ok(views.html.addTournament(tournamentForm))
    }
    def addGame(): Action[AnyContent] = Action { implicit request =>
        Ok(views.html.addGame(gameForm))
    }
}
