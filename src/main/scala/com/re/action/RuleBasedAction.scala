package com.re.action

import com.re.grammar.Grammar.Result
import com.re.rule.Rule

/**
  * Created by vparashar on 30/04/2017.
  */
case class RuleBasedAction(result: Rule) extends Action {

  import com.re.grammar.Grammar.RuleEvaluator

  override def execute(): Result = result.evaluate()
}
