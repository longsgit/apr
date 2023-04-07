package com.herbalife.labs.lab04;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.herbalife.labs.lab04.AccountConstants.*;
import static com.herbalife.labs.lab04.TransactionType.*;

public class Account {
    private UUID accountNumber;
    private double balance;
    private int withdrawCount;
    private List<Transaction> transactions;

    public Account(double balance) {
        if (balance < MINIMUM_BALANCE) {
            throw new RuntimeException("Minimum balance should be " + MINIMUM_BALANCE);
        }
        this.balance = balance;
        this.accountNumber = UUID.randomUUID();
        this.transactions = new ArrayList<>();
    }

    public int getWithdrawLimit() {
        return ACCOUNT_WITHDRAW_LIMIT;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction(accountNumber, amount, CREDIT));
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            throw new RuntimeException(MessageConstants.INSUFFICIENT_BALANCE);
        }
        withdrawCount++;
        balance -= amount;
        transactions.add(new Transaction(accountNumber, amount, DEBIT));
        if (withdrawCount > getWithdrawLimit()) {
            double fee = WITHDRAWAL_FEE / 100;
            balance -= fee;
            transactions.add(new Transaction(accountNumber, amount, DEBIT_WITHDRAWAL_FEE));
        }
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void printStatement() {
        for (Transaction txn : this.transactions) {
            System.out.println(txn);
        }
    }
}
