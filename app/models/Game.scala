package models

import java.util.Date

case class Game(_id: String, team1ID: String, team2ID: String, result: String, date: Date, referreID: String, scorers: Seq[String]) {

}
