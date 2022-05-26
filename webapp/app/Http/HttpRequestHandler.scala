package Http

import models.{Coach, Game, Player, Referee, Team, Tournament, User}
import play.api.libs.functional.syntax._
import play.api.libs.json.{JsPath, Json, Reads, Writes}
import scalaj.http.{Http, HttpResponse}

import java.util.Date
import java.text.{DateFormat, SimpleDateFormat}
import scala.annotation.unused

object HttpRequestHandler {

  def requestPOST(postData: String, requestAddress: String): Boolean = {
    try {
      // println("Parameters: "+ postData)
      val httpResponse: HttpResponse[String] = Http(requestAddress)
        .header("X-Requested-By","sdc")
        .header("Content-Type", "application/json;charset=UTF-8")
        .header("X-Stream" , "true")
        .header("Accept", "application/json")
        .postData(postData.getBytes)
        .asString

      @unused
      val response = if (httpResponse.code == 200) httpResponse.body
      else{
        println("Bad HTTP response: code = "+httpResponse.code )
        false
      }

      println(" Send Http Post Request (End) ")

      true

    } catch {
      case e: Exception => println("Error in sending Post request: " + e.getMessage)
        false
    }
  }

  def requestGET(requestAddress: String): String = {
    try {
      val httpResponse: HttpResponse[String] = Http(requestAddress).asString
      val response = if (httpResponse.code == 200) httpResponse.body
      else {
        println("Bad HTTP response: code = " + httpResponse.code)
        "ERROR"
      }
      println(" Send Http Get Request (End) ")
      response
    } catch {
      case e: Exception => println("Error in sending Get request: " + e.getMessage)
        "ERROR"
    }
  }


  /** Referees **/
  implicit val refereeWrites: Writes[Referee] = (referee: Referee) => Json.obj(
    "_id" -> referee._id,
    "name" -> referee.name,
    "surname" -> referee.surname,
    "nationality" -> referee.nationality,
    "dateOfBirth" -> referee.dateOfBirth
  )

  implicit val refereeReads: Reads[Referee] = (
    (JsPath \ "_id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "surname").read[String] and
      (JsPath \ "dateOfBirth").read[Date] and
      (JsPath \ "nationality").read[String]
    )(Referee.apply _)

  def insertReferee(referee: Referee): Unit = {
    requestPOST(Json.stringify(Json.toJson(referee)), "http://localhost:3001/referee")
  }

  def deleteReferee(referee: Referee): Unit = {
    requestGET(s"http://localhost:3001/referee/${referee._id}/delete")
  }

  def updateReferee(referee: Referee): Unit = {
    requestPOST(Json.stringify(Json.toJson(referee)), s"http://localhost:3001/referee/${referee._id}/update")
  }

  def getReferees: Seq[Referee] = {
    Json.parse(requestGET("http://localhost:3001/referee")).as[Seq[Referee]]
  }

  def getReferee(id: String): Referee = {
    Json.parse(requestGET(s"http://localhost:3001/referee/$id")).as[Referee]
  }

  /** Players **/
  implicit val playerWrites: Writes[Player] = (player: Player) => Json.obj(
    "_id" -> player._id,
    "name" -> player.name,
    "surname" -> player.surname,
    "dateOfBirth" -> player.dateOfBirth,
    "goals" -> player.goals,
    "appearances" -> player.appearances,
    "teamID" -> player.teamID,
  )

  implicit val playerReads: Reads[Player] = (
    (JsPath \ "_id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "surname").read[String] and
      (JsPath \ "dateOfBirth").read[Date] and
      (JsPath \ "goals").read[Int] and
      (JsPath \ "appearances").read[Int] and
      (JsPath \ "teamID").read[String]
    )(Player.apply _)

  def insertPlayer(player: Player): Unit = {
    requestPOST(Json.stringify(Json.toJson(player)), "http://localhost:3001/player")
  }

  def deletePlayer(player: Player): Unit = {
    requestGET(s"http://localhost:3001/player/${player._id}/delete")
  }

  def updatePlayer(player: Player): Unit = {
    requestPOST(Json.stringify(Json.toJson(player)), s"http://localhost:3001/player/${player._id}/update")
  }

  def getPlayers: Seq[Player] = {
    Json.parse(requestGET("http://localhost:3001/player")).as[Seq[Player]]
  }

  def getPlayer(id: String): Player = {
    Json.parse(requestGET(s"http://localhost:3001/player/$id")).as[Player]
  }

  /** Coaches **/
  implicit val coachWrites: Writes[Coach] = (coach: Coach) => Json.obj(
    "_id" -> coach._id,
    "name" -> coach.name,
    "surname" -> coach.surname,
    "dateOfBirth" -> coach.dateOfBirth,
    "teamID" -> coach.teamID,
  )

  implicit val coachReads: Reads[Coach] = (
    (JsPath \ "_id").read[String] and
      (JsPath \ "teamID").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "surname").read[String] and
      (JsPath \ "dateOfBirth").read[Date]
    )(Coach.apply _)

  def insertCoach(coach: Coach): Unit = {
    requestPOST(Json.stringify(Json.toJson(coach)), "http://localhost:3001/coach")
  }

  def deleteCoach(coach: Coach): Unit = {
    requestGET(s"http://localhost:3001/coach/${coach._id}/delete")
  }

  def updateCoach(coach: Coach): Unit = {
    requestPOST(Json.stringify(Json.toJson(coach)), s"http://localhost:3001/coach/${coach._id}/update")
  }

  def getCoaches: Seq[Coach] = {
    Json.parse(requestGET("http://localhost:3001/coach")).as[Seq[Coach]]
  }

  def getCoach(id: String): Coach = {
    Json.parse(requestGET(s"http://localhost:3001/coach/$id")).as[Coach]
  }

  /** Teams **/
  implicit val teamWrites: Writes[Team] = (team: Team) => Json.obj(
    "_id" -> team._id,
    "name" -> team.name,
    "coach" -> team.coach,
    "players" -> team.players,
    "tournaments" -> team.tournaments
  )

  implicit val teamReads: Reads[Team] = (
    (JsPath \ "_id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "coach").read[String] and
      (JsPath \ "players").read[Seq[String]] and
      (JsPath \ "tournaments").read[Seq[String]]
    )(Team.apply _)

  def insertTeam(team: Team): Unit = {
    requestPOST(Json.stringify(Json.toJson(team)), "http://localhost:3001/team")
  }

  def deleteTeam(team: Team): Unit = {
    requestGET(s"http://localhost:3001/team/${team._id}/delete")
  }

  def updateTeam(team: Team): Unit = {
    requestPOST(Json.stringify(Json.toJson(team)), s"http://localhost:3001/team/${team._id}/update")
  }

  def getTeams: Seq[Team] = {
    Json.parse(requestGET("http://localhost:3001/team")).as[Seq[Team]]
  }

  def getTeam(id: String): Team = {
    Json.parse(requestGET(s"http://localhost:3001/team/$id")).as[Team]
  }

  /** Tournamets **/
  implicit val tournamentWrites: Writes[Tournament] = (tournament: Tournament) => Json.obj(
    "_id" -> tournament._id,
    "name" -> tournament.name,
    "teams" -> tournament.teams,
    "games" -> tournament.games,
    "place" -> tournament.place,
    "date" -> tournament.date
  )

  implicit val tournamentReads: Reads[Tournament] = (
      (JsPath \ "_id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "place").read[String] and
      (JsPath \ "date").read[Date] and
      (JsPath \ "teams").read[Seq[String]] and
      (JsPath \ "games").read[Seq[String]]
    )(Tournament.apply _)

  def insertTournament(tournament: Tournament): Unit = {
    requestPOST(Json.stringify(Json.toJson(tournament)), "http://localhost:3001/tournament")
  }

  def deleteTournament(tournament: Tournament): Unit = {
    requestGET(s"http://localhost:3001/tournament/${tournament._id}/delete")
  }

  def updateTournament(tournament: Tournament): Unit = {
    requestPOST(Json.stringify(Json.toJson(tournament)), s"http://localhost:3001/tournament/${tournament._id}/update")
  }

  def getTournaments: Seq[Tournament] = {
    Json.parse(requestGET("http://localhost:3001/tournament")).as[Seq[Tournament]]
  }

  def getTournament(id: String): Tournament = {
    Json.parse(requestGET(s"http://localhost:3001/tournament/$id")).as[Tournament]
  }

  /** Games **/
  implicit val gameWrites: Writes[Game] = (game: Game) => Json.obj(
    "_id" -> game._id,
    "tourID" -> game.tourID,
    "team1ID" -> game.team1ID,
    "team2ID" -> game.team2ID,
    "result" -> game.result,
    "date" -> game.date,
    "refereeID" -> game.refereeID,
    "scorers" -> game.scorers
  )

  implicit val gameReads: Reads[Game] = (
    (JsPath \ "_id").read[String] and
      (JsPath \ "tourID").read[String] and
      (JsPath \ "team1ID").read[String] and
      (JsPath \ "team2ID").read[String] and
      (JsPath \ "result").read[String] and
      (JsPath \ "date").read[Date] and
      (JsPath \ "refereeID").read[String] and
      (JsPath \ "scorers").read[Seq[String]]
    )(Game.apply _)

  def insertGame(game: Game): Unit = {
    requestPOST(Json.stringify(Json.toJson(game)), "http://localhost:3001/game")
  }

  def deleteGame(game: Game): Unit = {
    requestGET(s"http://localhost:3001/game/${game._id}/delete")
  }

  def updateGame(game: Game): Unit = {
    requestPOST(Json.stringify(Json.toJson(game)), s"http://localhost:3001/game/${game._id}/update")
  }
  
  case class GameTest(_id:String, 
  tourID: String, 
  team1ID : String, 
  team2ID : String, 
  var result : String,
  var date : String, 
  var refereeID  : String, 
  var scorers: Seq[String])

    implicit val gameTestReads: Reads[GameTest] = (
      (JsPath \ "_id").read[String] and
        (JsPath \ "tourID").read[String] and
        (JsPath \ "team1ID").read[String] and
        (JsPath \ "team2ID").read[String] and
        (JsPath \ "result").read[String] and
        (JsPath \ "date").read[String] and
        (JsPath \ "refereeID").read[String] and
        (JsPath \ "scorers").read[Seq[String]]
      )(GameTest.apply _)

  def getGames: Seq[Game] = {
    val gamesWithStringDate: Seq[GameTest] = Json.parse(requestGET("http://localhost:3001/game")).as[Seq[GameTest]]
    val gamesWithDateDate: Seq[Game] = Json.parse(requestGET("http://localhost:3001/game")).as[Seq[Game]]

    val pattern: String = "yyyy-MM-dd'T'HH:mm"
    val simpleDateFormat: SimpleDateFormat = new SimpleDateFormat(pattern)

    for(i <- gamesWithStringDate.indices) {
      gamesWithDateDate(i).date = simpleDateFormat.parse(gamesWithStringDate(i).date)
    }
    gamesWithDateDate
  }

  def getGame(id: String): Game = {
    Json.parse(requestGET(s"http://localhost:3001/game/$id")).as[Game]
    
  }

  /** User **/

  implicit val userWrites: Writes[User] = (user: User) => Json.obj(
    "_id" -> user._id,
    "username" -> user.username,
    "password" -> user.password,
    "roles" -> user.roles,
    "isBanned" -> user.isBanned,
  )

  implicit val userReads: Reads[User] = (
      (JsPath \ "_id").read[String] and
      (JsPath \ "username").read[String] and
      (JsPath \ "password").read[String] and
      (JsPath \ "roles").read[Seq[String]] and
      (JsPath \ "isBanned").read[Boolean]
    )(User.apply _)

  def insertUser(user: User): Boolean = {
    if(requestPOST(Json.stringify(Json.toJson(user)), "http://localhost:3001/user")) true
    else false
  }

  def deleteUser(user: User): Unit = {
    requestGET(s"http://localhost:3001/user/${user._id}/delete")
  }

  def updateUser(user: User): Unit = {
    requestPOST(Json.stringify(Json.toJson(user)), s"http://localhost:3001/user/${user._id}/update")
  }

  def getUsers: Seq[User] = {
    Json.parse(requestGET("http://localhost:3001/user")).as[Seq[User]]
  }

  var loggedUser: Option[User] = None

  def getLoggedUser: Option[User] = {
    loggedUser
  }

  def getUser(username: String, password: String): Boolean = {
    val user: User = Json.parse(requestGET(s"http://localhost:3001/user/$username/$password")).as[User]
    if(user._id == "000000000000000000000000"){
      false
    }
    else {
      loggedUser = Some(user)
      true
    }
  }

  def getPlayersSortedByGoals(minValue: Int): Seq[Player]= {
    Json.parse(requestGET(s"http://localhost:3001/players/bygoals/$minValue")).as[Seq[Player]]
  }

  def getIncomingGames(fromDate: Date, toDate: Date): Seq[Game] = {
    val dateFormat: DateFormat = new SimpleDateFormat("MM-dd-yyyy")
    val fromDateString: String = dateFormat.format(fromDate)
    val toDateString: String = dateFormat.format(toDate)

    val gamesWithStringDate: Seq[GameTest] = Json.parse(requestGET(s"http://localhost:3001/games/bydate/$fromDateString/$toDateString")).as[Seq[GameTest]]
    val gamesWithDateDate: Seq[Game] = Json.parse(requestGET(s"http://localhost:3001/games/bydate/$fromDateString/$toDateString")).as[Seq[Game]]

    val pattern: String = "yyyy-MM-dd'T'HH:mm"
    val simpleDateFormat: SimpleDateFormat = new SimpleDateFormat(pattern)

    for(i <- gamesWithStringDate.indices) {
      gamesWithDateDate(i).date = simpleDateFormat.parse(gamesWithStringDate(i).date)
    }
    gamesWithDateDate
  }


  def getIncomingTournaments(fromDate: Date, toDate: Date): Seq[Tournament] = {
    val dateFormat: DateFormat = new SimpleDateFormat("MM-dd-yyyy")
    val fromDateString: String = dateFormat.format(fromDate)
    val toDateString: String = dateFormat.format(toDate)

    Json.parse(requestGET(s"http://localhost:3001/tournaments/bydate/$fromDateString/$toDateString")).as[Seq[Tournament]]
  }

}
