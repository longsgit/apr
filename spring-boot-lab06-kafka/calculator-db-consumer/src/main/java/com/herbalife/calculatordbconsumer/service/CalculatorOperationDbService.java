package com.herbalife.calculatordbconsumer.service;

import com.herbalife.calculatordbconsumer.entity.CalculatorOperation;
import com.herbalife.calculatordbconsumer.repo.CalculatorOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorOperationDbService {
    @Autowired
    private CalculatorOperationRepository calculatorOperationRepository;


    public void create(int num, String operation) {
        CalculatorOperation calculatorOperation = new CalculatorOperation();
        calculatorOperation.setNumber(num);
        calculatorOperation.setOperation(operation);
        calculatorOperationRepository.save(calculatorOperation);

    }
}
