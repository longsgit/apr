package com.herbalife.labs.lab04;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private UUID accountNumber;
    private double amount;
    private TransactionType type;
    private LocalDateTime dateTime;

    public Transaction(UUID accountNumber, double amount, TransactionType type) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
        this.dateTime = LocalDateTime.now();
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "accountNumber=" + accountNumber +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
