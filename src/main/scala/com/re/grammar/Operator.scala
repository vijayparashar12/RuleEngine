package com.re.grammar

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
  override def execute(lhs: Expression, rhs: Expression): Boolean = {
    if (lhs.isInstanceOf[Boolean] && rhs.isInstanceOf[Boolean]) {
      lhs.asInstanceOf[Boolean] && rhs.asInstanceOf[Boolean]
    } else {
      throw new Exception("And operator accepts only boolean parameters")
    }
  }
}



