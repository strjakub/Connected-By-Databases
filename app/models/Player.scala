package models

import java.util.Date


case class Player (_id: String, name : String, surname : String, dateOfBirth : Date,
                   var goals : Int, var appearances : Int, var teamId : String)

