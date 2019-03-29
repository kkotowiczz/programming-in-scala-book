import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

try {
  val fr = new FileReader("input.txt")
} catch {
  case ex: FileNotFoundException => println(ex + " FNFE")
  case ex: IOException => println(ex + " IOE")
} finally  {
  println("it's here")
}