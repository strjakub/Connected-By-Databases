package models

import java.util.Date


case class Player (val _id: String,var  name : String,var  surname : String,val  dateOfBirth : Date,
                   var goals : Int, var appearances : Int, var teamID : String){
                       def getData(): String = {
                            name + " " + surname
                        }
                   }

