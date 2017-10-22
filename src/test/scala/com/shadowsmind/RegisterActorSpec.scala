package com.shadowsmind

import akka.actor.ActorSystem
import akka.testkit.{ ImplicitSender, TestKit }
import org.scalatest.{ BeforeAndAfterAll, Matchers, WordSpecLike }

class RegisterActorSpec extends TestKit(ActorSystem("ActorSpec")) with ImplicitSender
  with WordSpecLike with Matchers with BeforeAndAfterAll {

  override def afterAll(): Unit = {
    TestKit.shutdownActorSystem(system)
  }

  "RegisterActor" must {

    val registerActor = system.actorOf(RegisterActor.props)

    "receive Register message and send with RegisterSuccess for new user" in {
      registerActor ! RegisterActor.Register("vasya", "asdf1234")

      expectMsg(RegisterActor.RegisterSuccess)
    }

    "receive FindUser message and send with FoundedUser" in {
      registerActor ! RegisterActor.Register("petya", "a32423dd")
      registerActor ! RegisterActor.FindUser("petya")

      expectMsg(RegisterActor.RegisterSuccess)
      expectMsg(RegisterActor.FoundedUser(Some(("petya", "a32423dd"))))
    }

  }

}
