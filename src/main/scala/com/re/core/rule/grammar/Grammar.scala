package com.re.core.rule.grammar

import com.re.core.rule.grammar.operators.Operator
import com.re.core.rule.{ActionableRule, Rule}

/**
  * Created by vparashar on 12/27/2016 AD.
  */
object Grammar {

  type Expression = Any
  type Result = Any
  type Parameter = String

  implicit class RuleEvaluator(rule: Rule) {
    def evaluate(): Result = {
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
        case s: String if s.startsWith("$") => namedParameters.getOrElse(s.substring(1), false)
        case _ => rule.lhs
      }

      val rhs = rule.rhs match {
        case s: String if s.startsWith("$") => namedParameters.getOrElse(s.substring(1), false)
        case _ => rule.rhs
      }
      rule.copy(lhs = lhs, rhs = rhs)
    }
  }

  implicit class ActionableRuleEvaluator(actionableRule: ActionableRule) {

    import com.re.core.action.ActionTransformer.RuleBasedActionTransformer

    def evaluate(): Option[Result] = {
      actionableRule.rule.
        transform(actionableRule.namedParameters)
        .evaluate() match {
        case true => Some(actionableRule.action.transform(actionableRule.namedParameters)
          .execute())
        case false => None
      }
    }
  }

}





