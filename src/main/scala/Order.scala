package org.lend

class Order(val amount: Long, val rate: Double, val term: Long) {
  val leaves = amount
}

class Borrow(amount: Long, rate: Double, term: Long)
  extends Order(amount, rate,term) {
}

class Lend(amount: Long, rate: Double, term: Long)
  extends Order(amount, rate, term) {
}
