import java.math.BigInteger

object JavaFactorial {
  def main(args: Array[String]): Unit = {
    println("Factorial of 10 is: " + factorial(new BigInteger("10")));
  }

  def factorial(x: BigInteger): BigInteger =
    if (x == BigInteger.ZERO) BigInteger.ONE else x.multiply(factorial(x.subtract(BigInteger.ONE)))
}
