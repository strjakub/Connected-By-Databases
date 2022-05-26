package models

case class Team( _id:String, var name:String, var coach:String,
                var players:Seq[String], var tournaments : Seq[String])
