package com.herbalife.calculatordbconsumer.repo;

import com.herbalife.calculatordbconsumer.entity.CalculatorOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorOperationRepository extends JpaRepository<CalculatorOperation, Integer> {
}
