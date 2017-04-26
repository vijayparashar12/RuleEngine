package com.re.rule

import com.re.rule.grammar.GT
import com.re.rule.grammar.Grammar._
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
      actionableRule.evaluate
      action.result mustEqual 1350d
    }
  }

}

case class DiscountAction(price: Double, discount: Double) extends Action {

  var result = 0d

  override def execute = {
    result = price * (1 - discount / 100)
  }
}
