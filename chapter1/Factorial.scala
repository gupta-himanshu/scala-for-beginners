import scala.BigInt

object Factorial {

  def main(args: Array[String]): Unit = {
    println("Factorial of 10 is: " + factorial(10));
  }

  private def factorial(x: BigInt): BigInt =
    if(x == 0) 1 else x * factorial(x-1)
}
