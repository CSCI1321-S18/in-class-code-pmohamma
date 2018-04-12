package recursion

object factorial extends App {
  def fibonacci(n:Int):Int = {
    if (n <= 2) 1
    else {
      fibonacci(n-1) + fibonacci(n-2)
    }
  }
  
  def factorial(n:Int):Int = {
    if (n<=1) 1
    else{
      n*factorial(n-1)
    }
  }
  
  println(factorial(5))
  println(fibonacci(9))
}