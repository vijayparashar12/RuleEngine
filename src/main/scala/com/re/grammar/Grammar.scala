package com.re.grammar

import com.re.grammar.Grammar.Expression

/**
  * Created by vparashar on 12/27/2016 AD.
  */
object Grammar {

  type Expression = Any
  type Result = AnyVal


  implicit class RuleEngineEvaluator(rule: Rule) {
    def evaluate(): Boolean = {
      val lhs = rule.lhs match {
        case Rule(_,_,_) => rule.lhs.asInstanceOf[Rule].evaluate()
        case _ => rule.lhs
      }
      val rhs = rule.rhs match {
        case Rule(_,_,_) => rule.rhs.asInstanceOf[Rule].evaluate()
        case _ => rule.rhs
      }

      rule.op match {
        case eq: EQ => eq.execute(lhs, rhs)
        case neq: NEQ => neq.execute(lhs, rhs)
        case _ => false
      }

    }
  }

}

case class Rule(lhs: Expression, op: Operator, rhs: Expression)



