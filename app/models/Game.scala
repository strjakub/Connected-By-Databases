package models

import java.time.LocalDateTime

case class Game(_id:String, team1Id : String, team2Id : String, result : String,
                date : LocalDateTime, refereeId  : String, scorers: Seq[String])
