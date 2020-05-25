package com.reunico.demo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class EvaluateBattle implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int warriors = (int) delegateExecution.getVariable("warriors");
        int enemyWarriors = (int) delegateExecution.getVariable("enemyWarriors");
        String battleStatus = "Undefined";
        boolean isWin = false;

        if ((warriors - enemyWarriors) > 1) {
            isWin = true;
            battleStatus = "Victory";
        }

        delegateExecution.setVariable("isWin", isWin);
        delegateExecution.setVariable("battleStatus", battleStatus);
    }
}
