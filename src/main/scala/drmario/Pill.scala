package drmario

class Pill extends Entity {
  private var x = 3
  private var y = 0
  val interval = 1.0
  private var delaySum = 0.0
  
  def colors: List[Block.Colors.Value] = List(Block.Colors.Yellow, 
      Block.Colors.Blue)
  
  def locations: List[(Int, Int)] = List((x, y), (x+1, y))
  
  def move(dx: Int): Unit = {
    x += dx
  }
  
  def update(delay: Double): Unit = {
    delaySum += delay
    if(delaySum >= interval) {
      y += 1
      delaySum = 0.0
    }
  }
}