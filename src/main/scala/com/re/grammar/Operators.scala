package com.re.grammar

import com.re.grammar.ExpressionConverter._
import com.re.grammar.Grammar.Expression

/**
  * Created by vparashar on 12/27/2016 AD.
  */
trait Operator {
  def execute(lhs: Expression, rhs: Expression): Boolean
}

case class EQ() extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Boolean = lhs == rhs
}

case class NEQ() extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Boolean = !EQ().execute(lhs, rhs)
}

case class AND() extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Boolean = lhs.toBoolean && rhs.toBoolean
}

case class OR() extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Boolean = lhs.toBoolean || rhs.toBoolean
}

case class GT() extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Boolean = lhs.toDouble > rhs.toDouble

}

case class GTE() extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Boolean = lhs.toDouble >= rhs.toDouble

}

case class LTE() extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Boolean = lhs.toDouble <= rhs.toDouble
}

case class LT() extends Operator {
  override def execute(lhs: Expression, rhs: Expression): Boolean = lhs.toDouble < rhs.toDouble
}




