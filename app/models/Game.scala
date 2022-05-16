package models

import java.time.LocalDateTime

case class Game(_id:String, tourID: String, team1ID : String, team2ID : String, result : String,
                date : LocalDateTime, var refereeId  : String, var scorers: Seq[String])
