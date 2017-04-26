package com.re.rule.grammar

import com.re.rule.Rule
import org.specs2.mutable.Specification

/**
  * Created by vparashar on 26/04/2017.
  */
class RuleEvaluatorTest extends Specification {

  "Rule(\"$foo\", EQ, 100) with parameters, Map(\"foo\" -> 100)" should {
    "transform to Rule(100, EQ, 100)" in {
      import Grammar.RuleEvaluator;
      val parameterizedRule = Rule("$foo", EQ, 100)
      val namedParametes = Map("foo" -> 100)
      val rule = parameterizedRule.transform(namedParametes);
      rule.lhs mustEqual 100
      rule.evaluate mustEqual true
      rule mustEqual Rule(100, EQ, 100)
    }

  }
}
