package com.reunico.demo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
public class FightEnemy implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        ArrayList<Boolean> army = (ArrayList<Boolean>) delegateExecution.getVariable("army");
        int enemyWarriors = (int) delegateExecution.getVariable("enemyWarriors");

        Thread.sleep(2000);

        if ( new Random().nextBoolean() ) {
            enemyWarriors--;
            System.out.println("Enemy warrior killed!");
        } else {
            army.remove(army.size() - 1);
            System.out.println("Our warrior killed!");
        }
        delegateExecution.setVariable("enemyWarriors", enemyWarriors);
        delegateExecution.setVariable("warriors", army.size());
        delegateExecution.setVariable("army", army);
    }
}
