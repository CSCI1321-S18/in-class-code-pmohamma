package networking

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintStream
import java.net.ServerSocket
import akka.actor.ActorSystem
import akka.actor.Props
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object ChatMain extends App {
  val system = ActorSystem("ChatSystem")
  val chatSuper = system.actorOf(Props[ChatSupervisor], "ChatSuper")
  
  implicit val ec = system.dispatcher
  system.scheduler.schedule(0.seconds, 0.1.seconds, chatSuper, ChatSupervisor.ProcessInput)

  //for actor based mud, you just leave out the stuff with sockets and all
  val ss = new ServerSocket(4004)
  while (true) {
    val sock = ss.accept()
    Future {
    val in = new BufferedReader(new InputStreamReader(sock.getInputStream))
    val out = new PrintStream(sock.getOutputStream)
    out.println("You Connected!")
    out.println("What is your name?")
    val name = in.readLine()
    println(name)
    chatSuper ! ChatSupervisor.NewChatter(name, sock, in, out) //console.in and console.out
   }
  }
}