package drmario

trait Entity {
  
  def colors: List[Block.Colors.Value]
  def locations: List[(Int, Int)]
}