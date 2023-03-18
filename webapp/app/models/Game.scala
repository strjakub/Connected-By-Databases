package models

import java.util.Date

case class Game(_id:String, tourID: String, team1ID : String, team2ID : String, var result : String,
                var date : Date, var refereeID  : String, var scorers: Seq[String])
