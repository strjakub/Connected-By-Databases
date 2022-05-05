package controllers

import models.InMemoryModel._

import javax.inject._
import models._
import play.api.mvc._
import play.api.i18n._

@Singleton
class AuthUserController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def login: Action[AnyContent] = Action {
    Ok(views.html.login())
  }

  def register: Action[AnyContent] = Action {
    Ok(views.html.register())
  }

  def validateLoginPost(): Action[AnyContent] = Action { request =>
    val postVals = request.body.asFormUrlEncoded
    postVals.map { args =>
      val username = args("username").head
      val password = args("password").head
      if(validateUser(username, password)) {
        Redirect(routes.HomeController.home())
      }
      else {
        Redirect(routes.AuthUserController.login())
      }
    }.getOrElse(Redirect(routes.AuthUserController.login()))
  }

  def createUser(): Action[AnyContent] = Action { request =>
    val postVals = request.body.asFormUrlEncoded
    postVals.map { args =>
      val username = args("username").head
      val password = args("password").head
      if(InMemoryModel.createUser(username, password)) {
        Redirect(routes.AuthUserController.login())
      }
      else {
        Redirect(routes.AuthUserController.login())
      }
    }.getOrElse(Redirect(routes.AuthUserController.login()))

  }
}