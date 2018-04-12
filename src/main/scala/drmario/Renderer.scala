package drmario

import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color

object Renderer {
  val blockSize = 30


  def render(gc: GraphicsContext, grid: PassableGrid): Unit = {
    gc.fill = Color.Black
    gc.fillRect(0, 0, 1000, 1000)
    for (entity <- grid.locsAndColors) {
      drawEntity(entity, gc)
    }
    for (block <- grid.nextPill) {
    drawEntity(block, gc, 6*blockSize)
    }
  }

  def drawEntity(entity: (Int, Int, Entity.Colors.Value), 
      gc: scalafx.scene.canvas.GraphicsContext, offsetX: Double = 0.0) = {
//    val shapeType = entity.shape
    val (x, y, colorEnum) = entity
      val color = colorEnum match {
        case Entity.Colors.Red => Color.Red
        case Entity.Colors.Yellow => Color.Yellow
        case Entity.Colors.Blue => Color.Blue
 //       case Entity.Colors.Blue => Color.Blue
      }
      gc.fill = color
//      shapeType match {
//        case DrMorioShape.Square =>
          gc.fillRect(x * blockSize + offsetX, y * blockSize,
            blockSize, blockSize)
//        case DrMorioShape.Circle =>
//          gc.fillOval(x * blockSize + offsetX, y * blockSize,
//            blockSize, blockSize)
//      }
  }
}