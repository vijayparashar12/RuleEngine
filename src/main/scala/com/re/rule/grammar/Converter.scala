package com.re.rule.grammar

import com.re.rule.grammar.Grammar.Expression

/**
  * Created by vparashar on 12/28/2016 AD.
  */
object ExpressionConverter {

  implicit class ExpressionToType(exp: Expression) {
    def toDouble: Double = {
      val doubleValue =
        exp match {
          case s: Short => Option(s.toDouble)
          case i: Int => Option(i.toDouble)
          case l: Long => Option(l.toDouble)
          case f: Float => Option(f.toDouble)
          case d: Double => Option(d)
          case _ => None
        }
      doubleValue.getOrElse(throw new NumberFormatException("Unsupported type for this operation"))
    }

    def toBoolean: Boolean = {
      val booleanValue = exp match {
        case b: Boolean => Option(b)
        case _ => None
      }
      booleanValue.getOrElse(throw new Exception("Operator accepts only boolean parameters"))
    }
  }

}
