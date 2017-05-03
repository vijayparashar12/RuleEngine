package com.re.core.rule

import com.re.core.action.Action
import com.re.core.rule.grammar.Grammar._
import com.re.core.rule.grammar.operators.GT
import org.specs2.mutable.Specification

/**
  * Created by vparashar on 26/04/2017.
  */
class ActionableRuleTest extends Specification {
  "Actionable rule" should {
    "if evaluates true executes action" in {
      val discount = Rule("$price", GT, 1000)
      val action = DiscountAction(1500d, 10d)
      val parameters = Map("price" -> 1500)
      val actionableRule = ActionableRule(discount, action, parameters)
      actionableRule.evaluate.getOrElse(0d) mustEqual 1350d
    }

    "if evaluates false skips action and returns None" in {
      val discount = Rule("$price", GT, 1000)
      val action = DiscountAction(1500d, 10d)
      val parameters = Map("price" -> 900)
      val actionableRule = ActionableRule(discount, action, parameters)
      val result = actionableRule.evaluate
      result mustEqual None
    }
  }

}

case class DiscountAction(price: Double, discount: Double) extends Action {
  override def execute = price * (1 - discount / 100)
}