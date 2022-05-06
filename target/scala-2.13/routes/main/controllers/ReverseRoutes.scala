// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:4
package controllers {

  // @LINE:4
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def players(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "players")
    }
  
    // @LINE:12
    def tournaments(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tournaments")
    }
  
    // @LINE:15
    def panel(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "panel")
    }
  
    // @LINE:4
    def home(): Call = {
    
      () match {
      
        // @LINE:4
        case ()  =>
          
          Call("GET", _prefix)
      
      }
    
    }
  
    // @LINE:13
    def teams(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "teams")
    }
  
  }

  // @LINE:6
  class ReverseAuthUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def createUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createUser")
    }
  
    // @LINE:10
    def logout(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout")
    }
  
    // @LINE:8
    def validateLoginPost(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "validatePost")
    }
  
    // @LINE:7
    def register(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "register")
    }
  
    // @LINE:6
    def login(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login")
    }
  
  }

  // @LINE:18
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
