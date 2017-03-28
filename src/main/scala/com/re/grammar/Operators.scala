package com.re.grammar

import com.re.grammar.ExpressionConverter._
import com.re.grammar.Grammar.Expression

/**
  * Created by vparashar on 12/27/2016 AD.
  */
trait Operator {
  def execute(lhs: Expression, rhs: Expression): Boolean
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




