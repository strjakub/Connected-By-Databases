// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:4
  HomeController_0: controllers.HomeController,
  // @LINE:6
  AuthUserController_1: controllers.AuthUserController,
  // @LINE:20
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:4
    HomeController_0: controllers.HomeController,
    // @LINE:6
    AuthUserController_1: controllers.AuthUserController,
    // @LINE:20
    Assets_2: controllers.Assets
  ) = this(errorHandler, HomeController_0, AuthUserController_1, Assets_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, AuthUserController_1, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.home()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.AuthUserController.login()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.AuthUserController.register()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """validatePost""", """controllers.AuthUserController.validateLoginPost()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createUser""", """controllers.AuthUserController.createUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.AuthUserController.logout()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """home""", """controllers.HomeController.home()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tournaments""", """controllers.HomeController.tournaments()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """teams""", """controllers.HomeController.teams()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """players""", """controllers.HomeController.players()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """panel""", """controllers.HomeController.panel()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:4
  private[this] lazy val controllers_HomeController_home0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_home0_invoker = createInvoker(
    HomeController_0.home(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "home",
      Nil,
      "GET",
      this.prefix + """""",
      """ANOTHER PAGE?""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_AuthUserController_login1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_AuthUserController_login1_invoker = createInvoker(
    AuthUserController_1.login(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AuthUserController",
      "login",
      Nil,
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_AuthUserController_register2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_AuthUserController_register2_invoker = createInvoker(
    AuthUserController_1.register(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AuthUserController",
      "register",
      Nil,
      "GET",
      this.prefix + """register""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_AuthUserController_validateLoginPost3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("validatePost")))
  )
  private[this] lazy val controllers_AuthUserController_validateLoginPost3_invoker = createInvoker(
    AuthUserController_1.validateLoginPost(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AuthUserController",
      "validateLoginPost",
      Nil,
      "POST",
      this.prefix + """validatePost""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:11
  private[this] lazy val controllers_AuthUserController_createUser4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createUser")))
  )
  private[this] lazy val controllers_AuthUserController_createUser4_invoker = createInvoker(
    AuthUserController_1.createUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AuthUserController",
      "createUser",
      Nil,
      "POST",
      this.prefix + """createUser""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:12
  private[this] lazy val controllers_AuthUserController_logout5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_AuthUserController_logout5_invoker = createInvoker(
    AuthUserController_1.logout(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AuthUserController",
      "logout",
      Nil,
      "GET",
      this.prefix + """logout""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_HomeController_home6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("home")))
  )
  private[this] lazy val controllers_HomeController_home6_invoker = createInvoker(
    HomeController_0.home(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "home",
      Nil,
      "GET",
      this.prefix + """home""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_HomeController_tournaments7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tournaments")))
  )
  private[this] lazy val controllers_HomeController_tournaments7_invoker = createInvoker(
    HomeController_0.tournaments(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "tournaments",
      Nil,
      "GET",
      this.prefix + """tournaments""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_teams8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("teams")))
  )
  private[this] lazy val controllers_HomeController_teams8_invoker = createInvoker(
    HomeController_0.teams(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "teams",
      Nil,
      "GET",
      this.prefix + """teams""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_HomeController_players9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("players")))
  )
  private[this] lazy val controllers_HomeController_players9_invoker = createInvoker(
    HomeController_0.players(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "players",
      Nil,
      "GET",
      this.prefix + """players""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_HomeController_panel10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("panel")))
  )
  private[this] lazy val controllers_HomeController_panel10_invoker = createInvoker(
    HomeController_0.panel(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "panel",
      Nil,
      "GET",
      this.prefix + """panel""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Assets_versioned11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned11_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:4
    case controllers_HomeController_home0_route(params@_) =>
      call { 
        controllers_HomeController_home0_invoker.call(HomeController_0.home())
      }
  
    // @LINE:6
    case controllers_AuthUserController_login1_route(params@_) =>
      call { 
        controllers_AuthUserController_login1_invoker.call(AuthUserController_1.login())
      }
  
    // @LINE:7
    case controllers_AuthUserController_register2_route(params@_) =>
      call { 
        controllers_AuthUserController_register2_invoker.call(AuthUserController_1.register())
      }
  
    // @LINE:9
    case controllers_AuthUserController_validateLoginPost3_route(params@_) =>
      call { 
        controllers_AuthUserController_validateLoginPost3_invoker.call(AuthUserController_1.validateLoginPost())
      }
  
    // @LINE:11
    case controllers_AuthUserController_createUser4_route(params@_) =>
      call { 
        controllers_AuthUserController_createUser4_invoker.call(AuthUserController_1.createUser())
      }
  
    // @LINE:12
    case controllers_AuthUserController_logout5_route(params@_) =>
      call { 
        controllers_AuthUserController_logout5_invoker.call(AuthUserController_1.logout())
      }
  
    // @LINE:13
    case controllers_HomeController_home6_route(params@_) =>
      call { 
        controllers_HomeController_home6_invoker.call(HomeController_0.home())
      }
  
    // @LINE:14
    case controllers_HomeController_tournaments7_route(params@_) =>
      call { 
        controllers_HomeController_tournaments7_invoker.call(HomeController_0.tournaments())
      }
  
    // @LINE:15
    case controllers_HomeController_teams8_route(params@_) =>
      call { 
        controllers_HomeController_teams8_invoker.call(HomeController_0.teams())
      }
  
    // @LINE:16
    case controllers_HomeController_players9_route(params@_) =>
      call { 
        controllers_HomeController_players9_invoker.call(HomeController_0.players())
      }
  
    // @LINE:17
    case controllers_HomeController_panel10_route(params@_) =>
      call { 
        controllers_HomeController_panel10_invoker.call(HomeController_0.panel())
      }
  
    // @LINE:20
    case controllers_Assets_versioned11_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned11_invoker.call(Assets_2.versioned(path, file))
      }
  }
}
