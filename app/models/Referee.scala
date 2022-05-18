package models

import java.util.Date

case class Referee(_id:String, 
                    name:String, 
                    surname:String,
                    dateOfBirth:Date, 
                    nationality:String) {
                        def getData(): String = {
                            name + " " + surname
                        }
                   }
