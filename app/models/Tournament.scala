package models

import java.util.Date

case class Tournament(_id: String,name: String, teams: Seq[String], games: Seq[String], place: String, date: Date) {}
