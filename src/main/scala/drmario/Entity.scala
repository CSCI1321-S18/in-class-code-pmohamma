package drmario

trait Entity {
  
  def colors: List[Block.Colors.Value]
  def locations: List[(Int, Int)]
  def selfSupporting:Boolean
}

object Entity {
  object Colors extends Enumeration {
    val Red, Blue, Yellow = Value
  }
}