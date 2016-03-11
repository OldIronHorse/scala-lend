package org.lend.test

import org.scalatest._
import org.lend.{Borrow, Lend}

abstract class UnitSpec extends FlatSpec with Matchers

class BorrowSpec extends UnitSpec {
  "A new borrow order" should "have a leaves quantity equal to the order qantity" in {
    val b = new Borrow(10000, 6.5, 10)
    assert(b.leaves == 10000)
  }
}

class LendSpec extends UnitSpec {
  "A new lend order" should "have a leaves quantity equal to the order quantity" in {
    val l = new Lend(10000, 6.5, 10)
    assert(l.leaves == 10000)
  }
}
