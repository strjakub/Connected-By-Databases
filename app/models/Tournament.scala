package models

import java.util.Date
case class Tournament ( _id:String,var name : String,var place : String,var date: Date,
                        var teams : Seq[String], var games : Seq[String])
