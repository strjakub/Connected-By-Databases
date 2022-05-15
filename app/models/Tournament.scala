package models

import java.util.Date

case class Tournament(_id: String, teams: Seq[String], games: Seq[String], place: String, date: Date) {}
