package com.re.grammar.operators

import com.re.grammar.Grammar.{Expression, Result}
import com.re.rule.ExpressionConverter._

/**
  * Created by vparashar on 12/27/2016 AD.
  */
trait Operator {
  def execute(lhs: Expression, rhs: Expression): Result
}

case object EQ extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Boolean = lhs == rhs
}

case object NEQ extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Boolean = !EQ.execute(lhs, rhs)
}

case object AND extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Boolean = lhs.toBoolean && rhs.toBoolean
}

case object OR extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Boolean = lhs.toBoolean || rhs.toBoolean
}

case object GT extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Boolean = lhs.toDouble > rhs.toDouble

}

case object GTE extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Boolean = lhs.toDouble >= rhs.toDouble

}

case object LTE extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Boolean = lhs.toDouble <= rhs.toDouble
}

case object LT extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Boolean = lhs.toDouble < rhs.toDouble
}

case object PERCENTAGE extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Double = lhs.toDouble * (1 - (rhs.toDouble / 100))
}

case object FLAT extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Double = lhs.toDouble - rhs.toDouble
}




