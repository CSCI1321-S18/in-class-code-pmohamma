package adt

import scala.reflect.ClassTag

class UnsortedArrayPQ[A: ClassTag](higherP: (A, A) => Boolean) extends MyPriorityQueue[A] {

  var arr = new Array[A](10)
  var end = 0
  
  def enqueue(a: A):Unit = {
    //TODO: Check if array is big enough
    arr(end) = a
    end += 1
  }
  
  def dequeue(): A = ???
  
  def isEmpty: Boolean = end == 0
  
  def peek: A = arr(getHighestPriority())
  
  private def getHighestPriority():Int = {
    var rover = 0  
    for (i <- 0 until end) {
      if (higherP(arr(i), arr(rover))) rover = i
    }
    rover
  }
}