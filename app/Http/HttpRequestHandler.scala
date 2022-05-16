package Http

import models.{Coach, Game, Player, Referee, Team, Tournament, User}
import play.api.libs.functional.syntax._
import play.api.libs.json.{JsPath, JsValue, Json, Reads, Writes}
import scalaj.http.{Http, HttpResponse}

import java.util.Date

object HttpRequestHandler {

  def requestPOST(postData: String, requestAddress: String): String = {
    try {
      println("Parameters: "+ postData)
      val httpResponse: HttpResponse[String] = Http(requestAddress)
        .header("X-Requested-By","sdc")
        .header("Content-Type", "application/json;charset=UTF-8")
        .header("X-Stream" , "true")
        .header("Accept", "application/json")
        .postData(postData.getBytes)
        .asString

      val response = if (httpResponse.code == 200) httpResponse.body
      else{
        println("Bad HTTP response: code = "+httpResponse.code )
        "ERROR"
      }

      println(" Send Http Post Request (End) ")

      return response

    } catch {
      case e: Exception => println("Error in sending Post request: " + e.getMessage)
        return "ERROR"
    }
  }

  def requestGET(requestAddress: String): String = {
    try {
      val httpResponse: HttpResponse[String] = Http(requestAddress).asString

      val response = if (httpResponse.code == 200) httpResponse.body
      else {
        println("Bad HTTP response: code = " + httpResponse.code)
        return "ERROR"
      }

      println(" Send Http Get Request (End) ")

      return response

    } catch {
      case e: Exception => println("Error in sending Get request: " + e.getMessage)
        return "ERROR"
    }
  }


  /** Referees **/
  implicit val refereeWrites: Writes[Referee] = new Writes[Referee] {
    override def writes(referee: Referee): JsValue = Json.obj(
      "_id" -> referee._id,
      "name" -> referee.name,
      "surname" -> referee.surname,
      "nationality" -> referee.nationality,
      "dateOfBirth" -> referee.dateOfBirth
    )
  }

  implicit val refereeReads: Reads[Referee] = (
    (JsPath \ "_id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "surname").read[String] and
      (JsPath \ "dateOfBirth").read[Date] and
      (JsPath \ "nationality").read[String]
    )(Referee.apply _)

  def insertReferee(referee: Referee): Unit = {
    requestPOST(Json.stringify(Json.toJson(referee)), "http://localhost:3001/referre")
  }

  def deleteReferee(referee: Referee): Unit = {
    requestGET(s"http://localhost:3001/referre/${referee._id}/delete")
  }

  def updateReferee(referee: Referee): Unit = {
    requestPOST(Json.stringify(Json.toJson(referee)), s"http://localhost:3001/referre/${referee._id}/update")
  }

  def getReferees(): Seq[Referee] = {
    return Json.parse(requestGET("http://localhost:3001/referre")).as[Seq[Referee]]
  }

  def getReferee(id: String): Referee = {
    return Json.parse(requestGET(s"http://localhost:3001/referre/$id")).as[Referee]
  }

  /** Players **/
  implicit val playerWrites: Writes[Player] = new Writes[Player] {
    override def writes(player: Player): JsValue = Json.obj(
      "_id" -> player._id,
      "name" -> player.name,
      "surname" -> player.surname,
      "dateOfBirth" -> player.dateOfBirth,
      "goals" -> player.goals,
      "apperances" -> player.appearances,
      "teamID" -> player.teamID,
    )
  }

  implicit val playerReads: Reads[Player] = (
    (JsPath \ "_id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "surname").read[String] and
      (JsPath \ "dateOfBirth").read[Date] and
      (JsPath \ "goals").read[Int] and
      (JsPath \ "apperances").read[Int] and
      (JsPath \ "teamID").readNullable[String]
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

  def getPlayers(): Seq[Player] = {
    return Json.parse(requestGET("http://localhost:3001/player")).as[Seq[Player]]
  }

  def getPlayer(id: String): Player = {
    return Json.parse(requestGET(s"http://localhost:3001/player/$id")).as[Player]
  }

  /** Coaches **/
  implicit val coachWrites: Writes[Coach] = new Writes[Coach] {
    override def writes(coach: Coach): JsValue = Json.obj(
      "_id" -> coach._id,
      "name" -> coach.name,
      "surname" -> coach.surname,
      "dateOfBirth" -> coach.dateOfBirth,
      "teamID" -> coach.teamID,
    )
  }

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

  def getCoaches(): Seq[Coach] = {
    return Json.parse(requestGET("http://localhost:3001/coach")).as[Seq[Coach]]
  }

  def getCoach(id: String): Coach = {
    return Json.parse(requestGET(s"http://localhost:3001/coach/$id")).as[Coach]
  }

  /** Teams **/
  implicit val teamWrites: Writes[Team] = new Writes[Team] {
    override def writes(team: Team): JsValue = Json.obj(
      "_id" -> team._id,
      "name" -> team.name,
      "coach" -> team.coachID,
      "players" -> team.players,
    )
  }

  implicit val teamReads: Reads[Team] = (
    (JsPath \ "_id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "coach").read[String] and
      (JsPath \ "players").read[Seq[String]]
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

  def getTeams(): Seq[Team] = {
    return Json.parse(requestGET("http://localhost:3001/team")).as[Seq[Team]]
  }

  def getTeam(id: String): Team = {
    return Json.parse(requestGET(s"http://localhost:3001/team/$id")).as[Team]
  }

  /** Tournamets **/
  implicit val tournamentWrites: Writes[Tournament] = new Writes[Tournament] {
    override def writes(tournament: Tournament): JsValue = Json.obj(
      "_id" -> tournament._id,
      "name" -> tournament.name,
      "teams" -> tournament.teams,
      "games" -> tournament.games,
      "place" -> tournament.place,
      "date" -> tournament.date
    )
  }

  implicit val tournamentReads: Reads[Tournament] = (
      (JsPath \ "_id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "teams").read[Seq[String]] and
      (JsPath \ "games").read[Seq[String]] and
      (JsPath \ "place").read[String] and
      (JsPath \ "date").read[Date]
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

  def getTournaments(): Seq[Tournament] = {
    return Json.parse(requestGET("http://localhost:3001/tournament")).as[Seq[Tournament]]
  }

  def getTournament(id: String): Tournament = {
    return Json.parse(requestGET(s"http://localhost:3001/tournament/$id")).as[Tournament]
  }

  /** Games **/
  implicit val gameWrites: Writes[Game] = new Writes[Game] {
    override def writes(game: Game): JsValue = Json.obj(
      "_id" -> game._id,
      "team1ID" -> game.team1ID,
      "team2ID" -> game.team2ID,
      "result" -> game.result,
      "date" -> game.date,
      "referreID" -> game.referreID,
      "scorers" -> game.scorers
    )
  }

  implicit val gameReads: Reads[Game] = (
    (JsPath \ "_id").read[String] and
      (JsPath \ "team1ID").read[String] and
      (JsPath \ "team2ID").read[String] and
      (JsPath \ "result").read[String] and
      (JsPath \ "date").read[Date] and
      (JsPath \ "referreID").read[String] and
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

  def getGames(): Seq[Game] = {
    return Json.parse(requestGET("http://localhost:3001/game")).as[Seq[Game]]
  }

  def getGame(id: String): Game = {
    return Json.parse(requestGET(s"http://localhost:3001/game/$id")).as[Game]
  }

  /** User **/
  //case class User(username: String, password: String, roles: Seq[String], isBanned: Boolean) {}

  implicit val userWrites: Writes[User] = new Writes[User] {
    override def writes(user: User): JsValue = Json.obj(
      "_id" -> user._id,
      "username" -> user.username,
      "password" -> user.password,
      "roles" -> user.roles,
      "isBanned" -> user.isBanned,
    )
  }

  implicit val userReads: Reads[User] = (
      (JsPath \ "_id").read[String] and
      (JsPath \ "username").read[String] and
      (JsPath \ "password").read[String] and
      (JsPath \ "roles").read[Seq[String]] and
      (JsPath \ "isBanned").read[Boolean]
    )(User.apply _)

  def insertUser(user: User): Unit = {
    requestPOST(Json.stringify(Json.toJson(user)), "http://localhost:3001/user")
  }

  def deleteUser(user: User): Unit = {
    requestGET(s"http://localhost:3001/user/${user._id}/delete")
  }

  def updateUser(user: User): Unit = {
    requestPOST(Json.stringify(Json.toJson(user)), s"http://localhost:3001/user/${user._id}/update")
  }

  def getUsers(): Seq[User] = {
    return Json.parse(requestGET("http://localhost:3001/user")).as[Seq[User]]
  }

  def getUser(id: String): User = {
    return Json.parse(requestGET(s"http://localhost:3001/user/$id")).as[User]
  }
}
