package com.re

import com.re.grammar.Grammar.RuleEvaluator
import com.re.grammar.operators.{EQ, NEQ}
import com.re.rule.Rule


/**
  * Created by vparashar on 12/27/2016 AD.
  */
object RuleEngine {


  def main(args: Array[String]): Unit = {
    //print("ready to build")
    /*val expression: Expression = 3.0d;
    expression match {
      case x: Int => println(x)
      case y: String => println(s"Some String $y")
      case _ => println("Some other type")
    }*/
    println(1.asInstanceOf[Double])
    println(Rule(true, EQ, true).evaluate())
    println(Rule(true, EQ, false).evaluate())

    val trueRule = Rule(true, EQ, true) //true
    val falseRule = Rule(false, EQ, true) //false
    val complexRule = Rule(trueRule, NEQ, falseRule) //true
    val anotherComplexRule = Rule(trueRule, NEQ, complexRule)
    print(anotherComplexRule.evaluate)
    println(s"Vijay" > "OMG")

    /*val test = 1
    val x = test match {
      case i: Int => "Int"
      case d: Double => "Double"
      case Number => "Number"

    }*/
  }
}
