package com.re.core.rule.grammar

import com.re.core.rule.grammar.Grammar.Expression

/**
  * Created by vparashar on 12/28/2016 AD.
  */
object ExpressionConverter {

  implicit class ExpressionToType(exp: Expression) {
    def toDouble: Double = {
      val doubleValue =
        exp match {
          case s: Short => Some(s.toDouble)
          case i: Int => Some(i.toDouble)
          case l: Long => Some(l.toDouble)
          case f: Float => Some(f.toDouble)
          case d: Double => Some(d)
          case _ => None
        }
      doubleValue.getOrElse(throw new NumberFormatException("Unsupported type for this operation"))
    }

    def toBoolean: Boolean = {
      val booleanValue = exp match {
        case b: Boolean => Some(b)
        case _ => None
      }
      booleanValue.getOrElse(throw new Exception("Operator accepts only boolean parameters"))
    }
  }

}
