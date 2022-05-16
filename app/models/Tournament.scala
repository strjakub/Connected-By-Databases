package models

import java.util.Date
case class Tournament ( _id:String, name : String, place : String, date: Date,
                       teams : Seq[String], games : Seq[String])
