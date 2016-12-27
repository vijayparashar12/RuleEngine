package com.re

import com.re.grammar.Grammar.RuleEvaluator
import com.re.grammar.{AND, EQ, NEQ, Rule}

/**
  * Created by vparashar on 12/27/2016 AD.
  */
class RuleEngine$Test extends org.specs2.mutable.Specification {

  "Basic Rule Evaluation" should {
    "Evaluates boolean rule" in {
      Rule(true, EQ(), true).evaluate() mustEqual true
    }
  }


  "Complicated Rule Evaluation" should {

    "Evaluates Rule with multiple nested rules" in {
      val trueRule = Rule(true, EQ(), true) //true
      val falseRule = Rule(false, EQ(), true) //false
      val complexRule = Rule(trueRule, NEQ(), falseRule) //true
      val anotherComplexRule = Rule(trueRule, NEQ(), complexRule)
      anotherComplexRule.evaluate mustEqual false
    }
  }

  "AND operator" should {
    "works with only boolean parameters" in {
      val lhs = Rule(true, EQ(), true).evaluate
      val rhs = lhs
      val andResult = AND().execute(lhs, rhs)
      print(andResult)
      andResult mustEqual  true
    }
  }

}
