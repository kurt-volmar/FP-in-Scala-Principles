package recfun

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1 else pascal(c, r - 1) + pascal(c - 1, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceHelper(chars: List[Char], parenStack: List[Char]): Boolean = {
      if(!chars.isEmpty) {
        if(chars.head == '(') {
          balanceHelper(chars.tail, chars.head :: parenStack)
        }
        else if(chars.head == ')') {
          if(parenStack.isEmpty || parenStack.head != '(') {
            balanceHelper(chars.tail, chars.head :: parenStack)
          }
          else {
            balanceHelper(chars.tail, parenStack.tail)
          }
        }
        else {
          balanceHelper(chars.tail, parenStack)
        }
      }
      else {
        parenStack.isEmpty
      }
    }
    balanceHelper(chars, List())
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(money < 0 || coins.isEmpty) {
      0
    }
    else if(money == 0) {
      1
    }
    else {
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
  }
