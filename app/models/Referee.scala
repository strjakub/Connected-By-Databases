package models

import akka.http.scaladsl.model.headers.Date

case class Referee(name:String, surname:String,
                   dateOfBirth:Date, nationality:String)
