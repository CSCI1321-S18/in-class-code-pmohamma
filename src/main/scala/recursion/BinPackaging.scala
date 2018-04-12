package recursion

object BinPackaging extends App {
  def packBins(items:Array[Int], bins: Array[Int]): Boolean = {
    def helper(i:Int):Boolean = {
      if(i >= items.length) true
      else{
        var ret = false
        for(j <- bins.indices) { //essentially for(j <- 0 until bins.length) {
          if(items(i) <= bins(j)) {
            bins(j) -= items(i)
            ret ||= helper(i+1)
            bins(j) -= items(i)
          }
        }
        ret
      }
    }
    helper(0)
  }
}