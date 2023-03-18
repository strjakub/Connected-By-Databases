package controllers

import models.{Referee, User}
import play.api.data.Form
import play.api.data.Forms._

import javax.inject._
import play.api.mvc._

import java.util.Date

case class refereeData (name:String, surname:String, dateOfBirth:Date, nationality:String)
//case class refereeToEdit(_id:String, name:String, surname:String, nationality:String)

@Singleton
class UserPanelController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport
{
  val refereeForm: Form[refereeData] = Form(mapping( "name" -> text, "surname"  -> text,
          "dateOfBirth" -> date, "nationality" -> text)(refereeData.apply)(refereeData.unapply)
  )
//  val editForm: Form[refereeToEdit] = Form(mapping( "_id" -> text ,"name" -> text, "surname"  -> text,
//    "nationality" -> text)(refereeToEdit.apply)(refereeToEdit.unapply)
//  )
//
//  var hello: Option[Referee] = None
//
//  var wantToEdit: Boolean = false;
  def panel(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      val user: Option[User] = Http.HttpRequestHandler.getUsers.find(u => u.username == username)
      val referees: Seq[Referee] = Http.HttpRequestHandler.getReferees
      Ok(views.html.panel(user)(referees)(views.html.addReferee(refereeForm)))
    }.getOrElse(Redirect(routes.AuthUserController.login()))
  }

  def createReferee(): Action[AnyContent] = Action { implicit request =>
    refereeForm.bindFromRequest().fold(
      formWithErrors => {
        println(formWithErrors.errors)
        Redirect(routes.UserPanelController.panel())
      },
      data =>{
        Http.HttpRequestHandler.insertReferee(Referee("", data.name, data.surname,
              data.dateOfBirth, data.nationality))
        Redirect(routes.UserPanelController.panel())
      }
    )
  }
  def deleteReferee(): Action[AnyContent] = Action { implicit request =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      val postVals = request.body.asFormUrlEncoded
      postVals.map { args =>
        val index = args("index").head
        val referee = Http.HttpRequestHandler.getReferee(index)
        Http.HttpRequestHandler.deleteReferee(referee)
        Redirect(routes.UserPanelController.panel())
      }.getOrElse(Redirect(routes.UserPanelController.panel()))
    }.getOrElse(Redirect(routes.UserPanelController.panel()))
  }

//  def editReferee(): Action[AnyContent] = Action { implicit request =>
//    val usernameOption = request.session.get("username")
//    usernameOption.map { username =>
//      val postVals = request.body.asFormUrlEncoded
//      postVals.map { args =>
//        val index = args("index").head
//        val referee = Http.HttpRequestHandler.getReferee(index)
//        hello = Some(referee)
//        wantToEdit = true;
//        val user: Option[User] = Http.HttpRequestHandler.getUsers.find(u => u.username == username)
//        val referees: Seq[Referee] = Http.HttpRequestHandler.getReferees
//        Ok(views.html.panel(user)(referees)(views.html.addReferee(refereeForm))(views.html.editRe()))
//      }.getOrElse(Redirect(routes.PlayerController.players()))
//    }.getOrElse(Redirect(routes.AuthUserController.login()))
//  }
//  def edit(): Action[AnyContent] = Action { implicit request =>
//    playerToEditForm.bindFromRequest().fold(
//      formWithErrors => {
//        println(formWithErrors.errors)
//        Redirect(routes.PlayerController.players())
//      },
//      data =>{
//        val playerToUpdate: Player = Http.HttpRequestHandler.getPlayer(data._id)
//        playerToUpdate.name = data.name
//        playerToUpdate.surname = data.surname
//        playerToUpdate.teamID = data.teamID
//        playerToUpdate.goals = data.goals
//        playerToUpdate.appearances = data.appearances
//        Http.HttpRequestHandler.updatePlayer(playerToUpdate)
//        Redirect(routes.PlayerController.players())
//      }
//    )
//  }
}
