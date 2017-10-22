package com.shadowsmind

import akka.actor.{ Actor, ActorLogging, Props }

import scala.collection.mutable

class RegisterActor extends Actor with ActorLogging {

  val users = mutable.Map.empty[String, String]

  import RegisterActor._

  override def receive: Receive = {
    case Register(nickName, password) ⇒
      log.debug(s"received message: Register($nickName, $password)")

      val exists = users.exists {
        case (k, _) ⇒
          k == nickName
      }

      if (exists) {
        sender ! RegisterError("user with this nickName already exists")
      } else {
        users.update(nickName, password)

        log.debug(s"registered new user: $nickName")

        sender ! RegisterSuccess
      }

    case FindUser(nickName) ⇒
      log.debug(s"received message: FindUser($nickName)")

      val foundedUser = users.find {
        case (k, _) ⇒
          k == nickName
      }

      sender ! FoundedUser(foundedUser)
  }

}

object RegisterActor {

  def props = Props(new RegisterActor)

  sealed trait RegisterMessage
  case class Register(nickName: String, password: String) extends RegisterMessage
  case class RegisterError(error: String) extends RegisterMessage
  case object RegisterSuccess extends RegisterMessage
  case class FindUser(nickName: String) extends RegisterMessage
  case class FoundedUser(user: Option[(String, String)]) extends RegisterMessage

}
