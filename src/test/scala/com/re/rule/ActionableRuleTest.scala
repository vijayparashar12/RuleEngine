package com.re.rule

import com.re.action.Action
import com.re.grammar.Grammar._
import com.re.grammar.operators.GT
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
      actionableRule.evaluate mustEqual 1350d
    }

    "if evaluates false skips action" in {
      val discount = Rule("$price", GT, 1000)
      val action = DiscountAction(1500d, 10d)
      val parameters = Map("price" -> 900)
      val actionableRule = ActionableRule(discount, action, parameters)
      val result = actionableRule.evaluate
      result mustEqual 1350d
    }
  }

}

case class DiscountAction(price: Double, discount: Double) extends Action {
  override def execute = price * (1 - discount / 100)
}