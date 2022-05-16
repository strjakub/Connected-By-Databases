package models

case class User(_id: String, username: String, password: String, roles: Seq[String], isBanned: Boolean) {}
