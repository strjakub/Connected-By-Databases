package controllers

import models.InMemoryModel._

import javax.inject._
import models._
import play.api.mvc._
import play.api.i18n._

@Singleton
class AuthUserController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def login: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      Redirect(routes.HomeController.home())
    }.getOrElse(Ok(views.html.login()))
  }

  def register: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      Redirect(routes.HomeController.home())
    }.getOrElse(Ok(views.html.register()))
  }

  def validateLoginPost(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val postVals = request.body.asFormUrlEncoded
    postVals.map { args =>
      val username = args("username").head
      val password = args("password").head
      if(validateUser(username, password)) {
        Redirect(routes.HomeController.home()).withSession("username" -> username)
      }
      else {
        Redirect(routes.AuthUserController.login())
      }
    }.getOrElse(Redirect(routes.AuthUserController.login()))
  }

  def createUser(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val postVals = request.body.asFormUrlEncoded
    postVals.map { args =>
      val username = args("username").head
      val password = args("password").head
      if(InMemoryModel.createUser(username, password)) {
        Redirect(routes.AuthUserController.login()).withSession("username" -> username)
      }
      else {
        Redirect(routes.AuthUserController.login())
      }
    }.getOrElse(Redirect(routes.AuthUserController.login()))
  }

  def logout: Action[AnyContent] = Action {
    // Redirect to login page and get rid of the session
    Redirect(routes.AuthUserController.login()).withNewSession
  }
}