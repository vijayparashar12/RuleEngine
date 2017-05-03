package com.re.core.action

import com.re.core.rule.grammar.Grammar.Result

/**
  * Created by vparashar on 26/04/2017.
  */
trait Action {
  def execute(): Result
}

object ActionTransformer {

  implicit class RuleBasedActionTransformer(action: Action) {
    def transform(namedParameters: Map[String, AnyVal]): Action = {
      import com.re.core.rule.grammar.Grammar.RuleEvaluator
      action match {
        case ruleBasedAction: RuleBasedAction => ruleBasedAction.copy(result = ruleBasedAction.result.transform(namedParameters))
        case _ => action
      }
    }
  }

}
