var assertionEnabled = true

def myAssert(predicate: () => Boolean) =
  if(assertionEnabled && !predicate())
    throw new AssertionError

// refactor, to not invoke like this myAssert(() => 5 > 3)

def byNameAssert(predicate: => Boolean) =
  if(assertionEnabled && !predicate)
    throw new AssertionError()

// now it can be called like: byNameAssert(5 > 3)