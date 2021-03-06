package adt

class MutableSLL[A] extends MySeq[A] {
  import MutableSLL.Node
  private var head: Node[A] = null
  private var _length = 0
  
  def apply(index:Int): A = {
    require((index <= length) && (index < _length))
    var rover = head
    for (i <- 0 until index){
      rover = rover.next
    }
    rover.data
  }
  
  def update(index:Int, a:A):Unit = {
    require((index <= length) && (index < _length))
    var rover = head
    for (i <- 0 until index){
      rover = rover.next
    }
    rover.data = a
  }
  
  def add(index:Int, a:A):Unit = {
    require((index >= 0) && (index <= _length))
    if (index == 0) {
      head = new Node(a, head)
    }
    else{
      var rover = head
      for (i <- 0 until index-1){
        rover = rover.next
      }
      rover.next = new Node[A](a, rover.next)
    }    
      _length += 1
  }
  
  def remove(index:Int):A = {
    require((index >= 0) && (index < _length))
    if(index == 0) {
      val ret = head.data
      head = head.next 
      _length -= 1
      ret
    }
    else{
      var rover = head
      for (i <- 0 until index-1){
        rover = rover.next
      }
      val ret = rover.next.data
      rover.next = rover.next.next
      _length -= 1
      ret
    }
  }
  
  def length:Int = _length
}

object MutableSLL{
  private class Node[A](var data:A, var next:Node[A])
}