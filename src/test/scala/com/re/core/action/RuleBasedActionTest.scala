package com.re.core.action

import com.re.core.rule.grammar.Grammar.ActionableRuleEvaluator
import com.re.core.rule.grammar.operators.{GT, PERCENTAGE}
import com.re.core.rule.{ActionableRule, Rule}
import org.specs2.mutable.Specification

/**
  * Created by vparashar on 30/04/2017.
  */
class RuleBasedActionTest extends Specification {

  "RuleBasedActionTest" should {
    "execute" in {
      val discountRule = Rule("$price", GT, 1000)
      val discountResult = Rule("$price", PERCENTAGE, 10)
      val action = RuleBasedAction(result = discountResult)
      val parameters = Map("price" -> 1500)
      val actionableRule = ActionableRule(discountRule, action, parameters)
      actionableRule.evaluate.getOrElse(0d) mustEqual 1350d
    }

  }
}
