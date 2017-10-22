package com.shadowsmind

import akka.actor.ActorSystem

object ExampleApp extends App {

  implicit val system = ActorSystem("ExampleSystem")

  val registerActor = system.actorOf(RegisterActor.props)

}