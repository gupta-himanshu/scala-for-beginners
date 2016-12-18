object Max {
  def main(args: Array[String]): Unit = {
    println("Max of 10 and 20 is: " + max(10, 20));
  }

  private def max(x: Int, y: Int): Int =
    if(x > y) x else y
}
