package models

case class Team( _id:String, name:String, coach:String,
                var players:Seq[String], var tournaments : Seq[String])
