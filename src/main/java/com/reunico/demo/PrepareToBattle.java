package com.reunico.demo;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class PrepareToBattle implements JavaDelegate {

    @Value("${maxWarriors}")
    private int maxWarriors;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        int warriors = (int) delegateExecution.getVariable("warriors");
        int enemyWarriors = (int) (Math.random() * 100);

        maxWarriors = maxWarriors == 0 ? 100 : maxWarriors;

        if (warriors < 1 || warriors > 100) {
            throw new BpmnError("warriorsError");
        }
        System.out.println("Enemy army: " + enemyWarriors + " vs. " + " our warriors: " + warriors);
        List<Boolean> army = new ArrayList<>(Collections.nCopies(warriors, true));
        delegateExecution.setVariable("enemyWarriors", enemyWarriors);
        delegateExecution.setVariable("army", army);

    }
}
