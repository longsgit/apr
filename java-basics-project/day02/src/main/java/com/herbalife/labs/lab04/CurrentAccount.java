package com.herbalife.labs.lab04;

import static com.herbalife.labs.lab04.AccountConstants.CURRENT_ACCOUNT_WITHDRAW_COUNT_LIMIT;
import static com.herbalife.labs.lab04.AccountConstants.CURRENT_ACCOUNT_WITHDRAW_LIMIT_AMOUNT;


public class CurrentAccount extends Account {
    public CurrentAccount(double balance) {
        super(balance);
    }

    @Override
    public int getWithdrawLimit() {
        return CURRENT_ACCOUNT_WITHDRAW_COUNT_LIMIT;
    }

    @Override
    public void withdraw(double amount) {
        if(amount > CURRENT_ACCOUNT_WITHDRAW_LIMIT_AMOUNT) {
            throw new RuntimeException(MessageConstants.WITHDRAW_LIMIT_EXCEEDED);
        }
        super.withdraw(amount);
    }
}
