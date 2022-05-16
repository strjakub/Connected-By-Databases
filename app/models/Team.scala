package models

case class Team( _id:String, name:String, coach:String,
                var players:List[String], var tournaments : List[String])
