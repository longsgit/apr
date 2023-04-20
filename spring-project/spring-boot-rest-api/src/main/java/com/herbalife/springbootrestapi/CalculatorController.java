package com.herbalife.springbootrestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Singleton by default; All the requests are processed by the same controller instance
@RestController
@RequestMapping("/calc")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/division")
    public CalculatorResult divide(@RequestBody CalculatorInputDto calculatorInputDto) {
        CalculatorResult calculatorResult = new CalculatorResult();
        calculatorResult.setNum1(calculatorInputDto.getNum1());
        calculatorResult.setNum2(calculatorInputDto.getNum2());
        calculatorResult.setOperation("Division");
        calculatorResult.setResult(calculatorService.divide(calculatorInputDto.getNum1(), calculatorInputDto.getNum2()));
        return calculatorResult;
    }

    @GetMapping("/sum/{num1}/{num2}")
    public int add(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
        return calculatorService.add(num1, num2);
    }

    @PostMapping("/difference/{num1}/{num2}")
    public int subtract(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
        return calculatorService.subtract(num1, num2);
    }

    @GetMapping("/square/{num}")
    public int square(@PathVariable int num) {
        return calculatorService.square(num);
    }

    @PostMapping("/product")
    public int multiply(@RequestParam int num1, @RequestParam("num2") int num2) {
        return calculatorService.multiply(num1, num2);
    }

}
