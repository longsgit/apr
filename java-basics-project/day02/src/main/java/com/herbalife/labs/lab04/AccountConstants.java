package com.herbalife.labs.lab04;

public interface AccountConstants {
    //can have variables
    //all the variables are implicitly public, static and final
    int ACCOUNT_WITHDRAW_LIMIT = 3;

    int CURRENT_ACCOUNT_WITHDRAW_COUNT_LIMIT = 10;
    double CURRENT_ACCOUNT_WITHDRAW_LIMIT_AMOUNT = 100000;

    int PREMIUM_CURRENT_ACCOUNT_WITHDRAW_COUNT_LIMIT = 100;
    double PREMIUM_CURRENT_ACCOUNT_WITHDRAW_LIMIT_AMOUNT = 1000000;
    double MINIMUM_BALANCE = 10000;
    double WITHDRAWAL_FEE = 0.5;

}
