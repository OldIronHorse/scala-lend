package org.lend.test

import org.lend.{OrderBook, Borrow, Lend}

class OrderBookSpec extends UnitSpec {
  "A new orderbook" should "be empty" in {
    val ob = new OrderBook(5)
    assert(ob.borrows.isEmpty)
    assert(ob.lends.isEmpty)
  }
  "A borrow added to an orderbook" should "end up in the borrows list" in {
    val ob0 = new OrderBook(5)
    val b = new Borrow(1000, 6.5, 5)
    val ob1 = ob0 + b
    assert(ob1.lends.isEmpty)
    assert(ob1.borrows == List(b))
  }
  "A lend added to an orderbook" should "end up in the lends list" in {
    val ob0 = new OrderBook(5)
    val l = new Lend(1000, 6.5, 5)
    val ob1 = ob0 + l
    assert(ob1.borrows.isEmpty)
    assert(ob1.lends == List(l))
  }
}
