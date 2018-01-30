package drmario

class Virus(x: Int, y: Int) extends Block with Entity {
  def color: Block.Colors.Value = Block.Colors.Red

  def colors: List[Block.Colors.Value] = List(color)
  def locations: List[(Int, Int)] = List((x,y))

}