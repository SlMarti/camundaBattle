package com.reunico.demo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;

@Component
public class CallToArms implements ExecutionListener {
    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        ArrayList<Boolean> army = (ArrayList<Boolean>) delegateExecution.getVariable("army");
        int reserves = (int) delegateExecution.getVariable("reserves");
        army.addAll(new ArrayList<>(Collections.nCopies(reserves, true)));
        delegateExecution.setVariable("army", army);
    }
}
