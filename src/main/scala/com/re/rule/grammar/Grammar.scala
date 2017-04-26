package com.re.rule.grammar

import com.re.rule.{ActionableRule, Rule}

/**
  * Created by vparashar on 12/27/2016 AD.
  */
object Grammar {

  type Expression = Any
  type Result = Any

  implicit class RuleEvaluator(rule: Rule) {
    def evaluate(): Boolean = {
      val lhs = rule.lhs match {
        case Rule(_, _, _) => rule.lhs.asInstanceOf[Rule].evaluate()
        case _ => rule.lhs
      }
      val rhs = rule.rhs match {
        case Rule(_, _, _) => rule.rhs.asInstanceOf[Rule].evaluate()
        case _ => rule.rhs
      }

      rule.op match {
        case op: Operator => op.execute(lhs, rhs)
        case _ => false
      }
    }

    def transform(namedParameters: Map[String, AnyVal]): Rule = {
      val lhs = rule.lhs match {
        case s: String if s.startsWith("$") => namedParameters.get(s.substring(1)).getOrElse(false)
        case _ => rule.lhs
      }

      val rhs = rule.rhs match {
        case s: String if s.startsWith("$") => namedParameters.get(s.substring(1)).getOrElse(false)
        case _ => rule.rhs
      }
      rule.copy(lhs = lhs, rhs = rhs)
    }
  }

  implicit class ActionableRuleEvaluator(actionableRule: ActionableRule) {
    def evaluate() = {
      actionableRule.rule
        .transform(actionableRule.namedParameters)
        .evaluate() match {
        case true => actionableRule.action.execute()
      }
    }
  }

}





