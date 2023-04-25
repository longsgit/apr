package com.herbalife.calculatorapi.controller;

import com.herbalife.calculatorapi.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/square/{num}")
    public HttpEntity<Void> square(@PathVariable int num) {
        calculatorService.publishSquare(num);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/increment/{num}")
    public HttpEntity<Void> increment(@PathVariable int num) {
        calculatorService.publishIncrement(num);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
