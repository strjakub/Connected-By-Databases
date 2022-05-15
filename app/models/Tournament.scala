package models

import java.util.Date
case class Tournament (name : String, place : String, date: Date, teams : List[String], games : List[String])
