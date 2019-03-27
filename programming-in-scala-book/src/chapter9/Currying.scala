def plainOldSum(x: Int, y: Int) = x + y
def curriedSum(x: Int)(y: Int) = x + y

def first(x: Int) = (y: Int) => x + y

val second = first(1)

println(second(4))

val onePlus = curriedSum(1)_

val twoPlus = curriedSum(2)_

def twice(op: Double => Double, x: Double) = op(op(x))

println(twice(_ + 1, 5))