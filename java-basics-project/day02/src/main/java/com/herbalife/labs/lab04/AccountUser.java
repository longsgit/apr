package com.herbalife.labs.lab04;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AccountUser {
    public static void main(String[] args) {
        //playWithNormalAccount();
        //playWithCurrentAccount();
        //playWithPremiumCurrentAccount();
    }

    private static void playWithPremiumCurrentAccount() {
        Account account = new PremiumCurrentAccount(20000000);
        account.deposit(1000);
        account.deposit(1000);
        account.deposit(1000);
        for (int i = 0; i < 110; i++) {
            account.withdraw(1000);
        }
        account.printStatement();
        System.out.println(String.format("Balance is %s", account.getBalance()));
    }

    private static void playWithCurrentAccount() {
        Account account = new CurrentAccount(200000);
        account.deposit(1000);
        account.deposit(1000);
        account.deposit(1000);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.printStatement();
        System.out.println(String.format("Balance is %s", account.getBalance()));
    }

    private static void playWithNormalAccount() {
        Account account = new Account(20000);
        account.deposit(1000);
        account.deposit(1000);
        account.deposit(1000);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.printStatement();
        System.out.println(String.format("Balance is %s", account.getBalance()));
    }
}
