package org.lend

class OrderBook(val term: Long,
                val borrows: List[Borrow] = List.empty,
                val lends: List[Lend] = List.empty) {
  def +(b: Borrow): OrderBook = {
    new OrderBook(term, b :: borrows, lends) 
  }
  def +(l: Lend): OrderBook = {
    new OrderBook(term, borrows, l :: lends)
  }
}
