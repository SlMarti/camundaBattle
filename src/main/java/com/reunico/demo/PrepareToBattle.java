package com.reunico.demo;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class PrepareToBattle implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        int warriors = (int) delegateExecution.getVariable("warriors");
        int enemyWarriors = (int) (Math.random() * 100);
        String battleStatus = "Undefined";
        boolean isWin = false;


        if (warriors < 1 || warriors > 100) {
            throw new BpmnError("warriorsError");
        }

        if ((warriors - enemyWarriors) > 0) {
            isWin = true;
            battleStatus = "Victory!";
        } else {
            battleStatus = "Fail! :( ";
        }


        delegateExecution.setVariable("enemyWarriors", enemyWarriors);
        delegateExecution.setVariable("battleStatus", battleStatus);
        delegateExecution.setVariable("isWin", isWin);

    }
}
