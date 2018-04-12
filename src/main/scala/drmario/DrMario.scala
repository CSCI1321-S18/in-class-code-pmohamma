//package drmario
//
//
//import scalafx.Includes._
//import scalafx.application.JFXApp
//import scalafx.scene.Scene
//import scalafx.scene.canvas.Canvas
//import scalafx.animation.AnimationTimer
//import scalafx.scene.input.KeyEvent
//import scalafx.scene.input.KeyCode
//import java.rmi.server.UnicastRemoteObject
//
//object DrMorio extends UnicastRemoteObject with JFXApp with RemoteClient {
//  stage = new JFXApp.PrimaryStage {
//    title = "Dr. Morio"
//    scene = new Scene(400, 600) {
//      val canvas = new Canvas(400, 600)
//      val gc = canvas.graphicsContext2D
//      content = canvas
//      
//      onKeyPressed = (e: KeyEvent) => {
//        e.code match {
//          case KeyCode.Up => grid.upPressed()
//          case KeyCode.Down => grid.downPressed()
//          case KeyCode.Left => grid.leftPressed()
//          case KeyCode.Right => grid.rightPressed()
//          case KeyCode.Space => grid.spacePressed()
//          case _ =>
//        }
//      }
//
//     onKeyReleased = (e: KeyEvent) => {
//        e.code match {
//          case KeyCode.Up => grid.upReleased()
//          case KeyCode.Down => grid.downReleased()
//          case KeyCode.Left => grid.leftReleased()
//          case KeyCode.Right => grid.rightReleased()
//          case KeyCode.Space => grid.spaceReleased()
//          case _ =>
//        }
//      }
//      
//
//    }
//  }
//}