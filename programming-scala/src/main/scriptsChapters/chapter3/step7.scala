import java.math.BigInteger

val big = new BigInteger("12345")

val greetStrings = new Array[String](3)

greetStrings(0) = "Hello"
greetStrings(1) = ", "
greetStrings(2) = "world!"

for(i <- 0 to 2)
  print(greetStrings(i))

