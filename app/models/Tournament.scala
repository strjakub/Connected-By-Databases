package models

import java.util.Date
case class Tournament ( _id:String, name : String, place : String, date: Date,
                        var teams : Seq[String], var games : Seq[String])
