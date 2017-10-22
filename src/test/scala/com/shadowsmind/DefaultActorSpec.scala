package com.shadowsmind

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

class DefaultActorSpec extends TestKit(ActorSystem("ActorSpec")) with ImplicitSender
  with WordSpecLike with Matchers with BeforeAndAfterAll{

}
