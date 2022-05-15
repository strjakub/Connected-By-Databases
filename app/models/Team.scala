package models

case class Team(name:String, coach:String, var players:List[String], var tournaments : List[String])
