package models

import akka.http.scaladsl.model.headers.Date

case class Tournament (teams : Array[String], games : Array[String], place : String, date: Date)
