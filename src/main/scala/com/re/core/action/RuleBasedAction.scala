package com.re.core.action

import com.re.core.rule.Rule
import com.re.core.rule.grammar.Grammar.Result

/**
  * Created by vparashar on 30/04/2017.
  */
case class RuleBasedAction(result: Rule) extends Action {

  import com.re.core.rule.grammar.Grammar.RuleEvaluator

  override def execute(): Result = result.evaluate()
}
