var more = 1

val addMore = (x: Int) => x + more

def makeIncreaser(x: Int) = (more: Int) => x + more

val sevko = makeIncreaser(299)

println(sevko(9))
