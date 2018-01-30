package basics

object RandomStuff {
  def findAndRemove[A](lst: List[A], isVictim: A => Boolean): List[A] = {
    lst.find(isVictim) match {
      case Some(victim) => lst.filter(_ != victim)
      case None => lst
    }
  }
}