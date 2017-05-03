package com.re.core.rule

import com.re.core.action.Action
import com.re.core.rule.grammar.Grammar.Expression
import com.re.core.rule.grammar.operators.Operator


case class Rule(lhs: Expression, op: Operator, rhs: Expression)

case class ActionableRule(rule: Rule, action: Action, namedParameters: Map[String, AnyVal])
