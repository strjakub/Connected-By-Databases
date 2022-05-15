package models

import java.time.LocalDateTime

case class Game(team1Id : String, team2Id : String, result : String,
                date : LocalDateTime, refereeId  : String, scorers: List[String])