package com.re.rule

import com.re.action.Action
import com.re.grammar.Grammar.Expression
import com.re.grammar.operators.Operator


case class Rule(lhs: Expression, op: Operator, rhs: Expression)

case class ActionableRule(rule: Rule, action: Action, namedParameters: Map[String, AnyVal])
