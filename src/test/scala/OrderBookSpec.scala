package org.lend.test

import org.lend.{OrderBook, Borrow, Lend}

class OrderBookSpec extends UnitSpec {
  "An orderbook" should "be empty when created" in {
    val ob = new OrderBook(5)
    assert(ob.borrows.isEmpty)
    assert(ob.lends.isEmpty)
  }
  it should "add borrow orders to the borrows list" in {
    val ob0 = new OrderBook(5)
    val b = new Borrow(1000, 6.5, 5)
    val ob1 = ob0 + b
    assert(ob1.lends.isEmpty)
    assert(ob1.borrows == List(b))
  }
  it should "add lend orders to the lends list" in {
    val ob0 = new OrderBook(5)
    val l = new Lend(1000, 6.5, 5)
    val ob1 = ob0 + l
    assert(ob1.borrows.isEmpty)
    assert(ob1.lends == List(l))
  }
  it should "sort the borrows list by rate (decreasing)." in {
    val ob0 = new OrderBook(5)
    val b1 = new Borrow(1000, 6.5, 5)
    val b2 = new Borrow(2000, 8.5, 5)
    val b3 = new Borrow(3000, 5.5, 5)
    val ob1 = ob0 + b1 + b2 + b3
    assert(ob1.borrows == List(b2, b1, b3))
  }
  it should "sort the lends list by rate (increasing)." in {
    val ob0 = new OrderBook(5)
    val l1 = new Lend(1000, 6.5, 5)
    val l2 = new Lend(2000, 8.5, 5)
    val l3 = new Lend(3000, 5.5, 5)
    val ob1 = ob0 + l1 + l2 + l3
    assert(ob1.lends== List(l3, l1, l2))
  }
  //TODO maintain time priority? favour big or small orders?
}
