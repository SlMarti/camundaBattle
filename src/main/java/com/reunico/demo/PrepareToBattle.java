package com.reunico.demo;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class PrepareToBattle implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        int warriors = (int) delegateExecution.getVariable("warriors");
        int enemyWarriors = (int) (Math.random() * 100);
        System.out.println("Enemy warriors: " + enemyWarriors);
        if (warriors < 1 || warriors > 100) {
            throw new BpmnError("warriorsError");
        }

        List<Integer> army = new ArrayList<>(Collections.nCopies(warriors, 0));

        delegateExecution.setVariable("army", army);
        delegateExecution.setVariable("enemyWarriors", enemyWarriors);

    }
}
