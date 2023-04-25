package com.herbalife.calculatordbconsumer.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "calculator_operations")
public class CalculatorOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int number;

    @Column
    private String operation;
}
