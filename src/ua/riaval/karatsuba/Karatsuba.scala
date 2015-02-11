package ua.riaval.karatsuba

object Karatsuba {

  val T = 10
  val MIN_LENGTH = 4

  /*
  * Simple notation
  * acT^2 + ((a + b)(c + d) - ac - bd)T + bd
  * */
  def multiplication(first: BigInt, second: BigInt): BigInt =
    if (first.toString().length < MIN_LENGTH || second.toString().length < MIN_LENGTH) first * second
    else {
      val (a, b) = split(first)
      val (c, d) = split(second)

      multiplication(a , c) * T * T + (multiplication(a + b , c + d) - multiplication(a , c) - multiplication(b , d)) * T + multiplication(b , d)
    }

  private def split(number: BigInt): (BigInt, BigInt) = {
    if (number.toString().length == 1) (0, number)
    else number /% 10
  }

}
