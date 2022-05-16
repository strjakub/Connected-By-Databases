package models

import java.util.Date


case class Player (_id: String, name : String, surname : String, dateOfBrith : Date,
                   var goals : Int, var appearances : Int, var teamId : Option[String])

