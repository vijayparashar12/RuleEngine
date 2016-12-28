package com.re.grammar

import com.re.grammar.ExpressionConverter._
import com.re.grammar.Grammar._
import org.specs2.mutable.Specification

/**
  * Created by vparashar on 12/28/2016 AD.
  */
class ExpressionToTypeTest extends Specification {

  "ExpressionToTypeTest" should {
    "toDouble converts Numeric Expressions to double value" in {
      val intExp: Expression = 5
      intExp.toDouble mustEqual 5d

      val shortExp: Expression = 5.toShort
      shortExp.toDouble mustEqual 5d
    }

    "toBoolean" in {
      "Converts Boolean Expressions to boolean value" in {
        val booleanExp: Expression = true
        booleanExp.toBoolean mustEqual true
      }
      "Throws Exception for non boolean Expression" in {
        val exp: Expression = 5
        exp.toBoolean must throwA[Exception]
      }

    }

  }
}
