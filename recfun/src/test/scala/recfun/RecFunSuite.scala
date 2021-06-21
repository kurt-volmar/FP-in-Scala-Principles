package recfun

import recfun.RecFun.pascal

class RecFunSuite extends munit.FunSuite:
  import RecFun.*

  // ------ balance tests -----------------------------------------------------

//  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
//    assert(balance("(if (zero? x) max (/ 1 x))".toList))
//  }
//
//  test("balance: 'I told him ...' is balanced") {
//    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
//  }
//
//  test("balance: ':-)' is unbalanced") {
//    assert(!balance(":-)".toList))
//  }
//
//  test("balance: counting is not enough") {
//    assert(!balance("())(".toList))
//  }
  

  // ------ countChange tests -------------------------------------------------

  test("countChange: example given in instructions") {
    assertEquals(countChange(4,List(1,2)), 3)
  }

  test("countChange: sorted CHF") {
    assertEquals(countChange(300,List(5,10,20,50,100,200,500)), 1022)
  }

  test("countChange: no pennies") {
    assertEquals(countChange(301,List(5,10,20,50,100,200,500)), 0)
  }

  test("countChange: unsorted CHF") {
    assertEquals(countChange(300,List(500,5,50,100,20,200,10)), 1022)
  }
  
  // My countChange Tests
  test("countChange: no coins") {
    assertEquals(countChange(4, List()), 0)
  }
  
  test("countChange: money smaller than denominations") {
    assertEquals(countChange(1, List(2, 3)), 0)
  }
  
  test("countChange: 1:1 match") {
    assertEquals(countChange(1, List(1)), 1)
  }

  test("countChange: $1 w/ [1, 2]") {
    assertEquals(countChange(1, List(1, 2)), 1)
  }

  test("countChange: $2 w/ [1, 2]") {
    assertEquals(countChange(2, List(1, 2)), 2)
  }

  // ------ pascal tests ------------------------------------------------------

//  test("pascal: col=0,row=2") {
//    assertEquals(pascal(0, 2), 1)
//  }
//
//  test("pascal: col=1,row=2") {
//    assertEquals(pascal(1, 2), 2)
//  }
//
//  test("pascal: col=1,row=3") {
//    assertEquals(pascal(1, 3), 3)
//  }
//  
//  // My Tests
//  test("pascal: col=0, row=0") {
//    assertEquals(pascal(0, 0), 1)
//  }
//  test("pascal: col=0, row=1") {
//    assertEquals(pascal(0, 1), 1)
//  }
//  test("pascal: col=1, row=1") {
//    assertEquals(pascal(1, 1), 1)
//  }
//  test("pascal: col=1, row=2") {
//    assertEquals(pascal(1, 2), 2)
//  }
//  test("pascal: col=1, row=4") {
//    assertEquals(pascal(1, 4), 4)
//  }

  import scala.concurrent.duration.*
  override val munitTimeout = 10.seconds
