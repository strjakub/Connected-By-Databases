package controllers
import models.{Game, Tournament}
import play.api.data._
import play.api.data.Forms._

import javax.inject._
import play.api.mvc._
import java.util.Date
import java.time.LocalDateTime
case class tourData(name:String, place:String,date:Date,teams:Seq[String],games:Seq[String])
case class gameData(team1Id:String, team2Id:String,result:String,date:LocalDateTime,refereeId:String, scorers:Seq[String])

@Singleton
class TournamentController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
    val tournamentForm: Form[tourData] = Form(mapping("name" -> text,
        "place" -> text, "date" -> date,
        "teams" -> seq(text), "games" -> seq(text)
        )(tourData.apply)(tourData.unapply)
    )
    val gameForm: Form[gameData] = Form(mapping(
        "team1Id" -> text, "team2Id" -> text,
        "result" -> text, "date" -> localDateTime,
        "refereeId" -> text, "scorers" -> seq(text)
        )(gameData.apply)(gameData.unapply)
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
