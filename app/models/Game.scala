package models

import akka.http.scaladsl.model.DateTime

case class Game(team1Id : String, team2Id : String, result : String,
                date : DateTime, refereeId  : String, scorers: Array[String])