package models

import java.time.LocalDateTime

case class Game(_id:String, tourID: String, team1ID : String, team2ID : String, var result : String,
                date : LocalDateTime, var refereeID  : String, var scorers: Seq[String])
