package com.re.rule

import com.re.rule.grammar.Grammar.Expression
import com.re.rule.grammar.Operator

/**
  * Created by vparashar on 26/04/2017.
  */
trait Action {
  def execute(): Unit
}

case class Rule(lhs: Expression, op: Operator, rhs: Expression)

case class ActionableRule(rule: Rule, action: Action, namedParameters: Map[String, AnyVal])
