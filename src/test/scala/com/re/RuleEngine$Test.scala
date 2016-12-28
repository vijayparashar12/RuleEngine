package com.re

import com.re.grammar.Grammar.RuleEvaluator
import com.re.grammar._

/**
  * Created by vparashar on 12/27/2016 AD.
  */
class RuleEngine$Test extends org.specs2.mutable.Specification {

  "Rule Evaluation [rule.evaluate()]" should {
    "Evaluates Rule(true, EQ(), true) => true" in {
      Rule(true, EQ(), true).evaluate() mustEqual true
    }
    "Evaluates Rule(5, EQ(), 5) => true" in {
      Rule(5, EQ(), 5).evaluate() mustEqual true
    }
    "Evaluates Rule(6, EQ(), 5) => false" in {
      Rule(6, EQ(), 5).evaluate() mustEqual false
    }
    "Evaluates Complex Rule with multiple nested rules as Rule(trueRule, EQ(), complexTrueRule) => true" in {
      val trueRule = Rule(true, EQ(), true) //true
      val falseRule = Rule(false, EQ(), true) //false
      val complexTrueRule = Rule(trueRule, NEQ(), falseRule) //true
      val anotherComplexRule = Rule(trueRule, EQ(), complexTrueRule)
      anotherComplexRule.evaluate mustEqual true
    }
  }

  "AND operator" should {
    "Evaluate [true AND true] = true" in {
      AND().execute(true, true) mustEqual true
    }
    "Evaluate [true AND false] = false" in {
      AND().execute(true, false) mustEqual false
    }
    "Evaluate [false AND false] = false" in {
      AND().execute(false, false) mustEqual false
    }
    "Throws exception if parameters are not boolean, [Rule(true, EQ(), true) AND 5] = Exception" in {
      val lhs = Rule(true, EQ(), true)
      val rhs = 5
      AND().execute(lhs, rhs) must throwA(new Exception("Operator accepts only boolean parameters"))
    }
  }

  "OR operator" should {
    "Evaluate [true or false] = true" in {
      OR().execute(true, false) mustEqual true
    }
    "Evaluate [false or false] = false" in {
      OR().execute(false, false) mustEqual false
    }
    "Evaluate [true or true] = true" in {
      OR().execute(true, true) mustEqual true
    }
    "Throws exception if parameter are not boolean, [5 or 5] = Exception" in {
      OR().execute(5, 5) must throwA(new Exception("Operator accepts only boolean parameters"))
    }
  }

  "EQ operator" should {
    "Evaluate [5 EQ 5] = true" in {
      EQ().execute(5, 5) mustEqual true
    }
    "Evaluate [5 EQ 5.5] = false" in {
      EQ().execute(5, 5.5d) mustEqual false
    }
    "Evaluate [5 EQ 5.0] = true , scala == operator is used underlying" in {
      EQ().execute(5, 5.0d) mustEqual true
    }
    "Evaluate [true EQ true] = true" in {
      EQ().execute(true, true) mustEqual true
    }
    "Evaluate [\"foo\" EQ \"foo\"] = true" in {
      EQ().execute("foo", "foo") mustEqual true
    }
    "Evaluate [\"foo\" EQ \"Foo\"] = false" in {
      EQ().execute("foo", "Foo") mustEqual false
    }
  }

  "NEQ Operator" should {
    "Evaluate as [!EQ] " in {
      !EQ().execute(true, true) mustEqual NEQ().execute(true, true)
    }
  }

}
