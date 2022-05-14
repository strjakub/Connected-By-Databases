package models

import akka.http.scaladsl.model.headers.Date

case class Coach (teamId : String, name : String,
                  surname : String, dateOfBirth : Date)
