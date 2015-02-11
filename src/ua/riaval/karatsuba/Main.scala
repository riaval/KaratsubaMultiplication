package ua.riaval.karatsuba

object Main {

  val T = 10
  val MIN_LENGTH = 4

  def main(args: Array[String]) {
    println(BigInt(35).bitCount)

//    println(
//      karatsuba(12, 23)
//    )
  }

  def split(number: BigInt): (BigInt, BigInt) = {
    if (number.bitLength < 2) null
    else number /% 10 //(number / 10, number % 10)
  }

  /*
  * Simple notation
  * acT^2 + ((a + b)(c + d) - ac - bd)T + bd
  * */
  def karatsuba(first: BigInt, second: BigInt): BigInt =
    if (first.bitLength > MIN_LENGTH || second.bitLength > MIN_LENGTH) first * second
    else {
      val (a, b) = split(first)
      val (c, d) = split(second)

      a * c * T * T + ((a + b) * (c + d) - a * c - b * d) * T + b * d
    }


}
