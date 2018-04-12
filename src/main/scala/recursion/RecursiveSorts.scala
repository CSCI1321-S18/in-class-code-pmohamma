package recursion

object RecursiveSorts extends App {
  
//  def mergeSort(): ??? = {
//    
//  }
  
  def badQuickSort[A](lst: List[A])(lt: (A, A) => Boolean): List[A] = lst match {
    case Nil => lst
    case h :: Nil => lst
    case pivot :: t => {
      val (less, greater) = t.partition(x => lt(x, pivot))
      badQuickSort(less)(lt) ++ (pivot :: badQuickSort(greater) (lt))
    }
  }
  
def quicksort[A](arr: Array[A])(lt: (A, A) => Boolean): Unit = {
    def insertionHelper(arr: Array[A], start: Int, end: Int)(lt: (A, A) => Boolean): Unit = {
      for(i <- start+1 until end) {
        var j = i
        val tmp = arr(j)
        while(j > 0 && lt(tmp, arr(j-1))) {
          arr(j) = arr(j-1)
          j -= 1
        }
        arr(j) = tmp
      }
    }
    def helper(start: Int, end: Int): Unit = {
      if (end - start < 10) insertionHelper(arr, start, end)(lt) else {
        val pIndex = util.Random.nextInt(end - start) + start
        val tmp = arr(start)
        arr(start) = arr(pIndex)
        arr(pIndex) = tmp
        var low = start + 1
        var high = end - 1
        while (low <= high) {
          if (lt(arr(low), arr(start))) {
            low += 1
          } else {
            val tmp = arr(low)
            arr(low) = arr(high)
            arr(high) = tmp
            high -= 1
          }
        }
        val tmp2 = arr(high)
        arr(high) = arr(start)
        arr(start) = tmp2
        helper(start, high)
        helper(low, end)
      }
    }
    helper(0, arr.length)
  }
}