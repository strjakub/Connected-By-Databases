package models

import java.util.Date

case class Coach (_id: String, var teamID : String, name : String,
                  surname : String, dateOfBirth : Date)
