package com.reunico.demo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class EvaluateBattle implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

    }
}
