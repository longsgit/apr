package com.herbalife.labs.lab08;

import static com.herbalife.labs.lab08.ValidationConstants.*;

public class Lab08 {
    public static void main(String[] args) {
        String userName = "myadmin";
        String password = "Myadmin123";

        boolean userNameValid = isNotNull
                .and(isNotBlank)
                .and(isNotEmpty)
                .and(lengthValidator.apply(6, 12))
                //.and(userNameLength)
                .test(userName);
        System.out.println("User name is " + userNameValid);

        boolean passwordValid = isNotNull
                .and(isNotBlank)
                .and(isNotEmpty)
                .and(lengthValidator.apply(8, 14))
                //.and(passwordLength)
                .and(hasDigit)
                .and(hasUpperCase)
                .test(password);
        System.out.println("Password is " + passwordValid);

        password = null;
        passwordValid = isNotNull
                .and(isNotBlank)
                .and(isNotEmpty)
                .and(lengthValidator.apply(8, 14))
                //.and(passwordLength)
                .and(hasDigit)
                .and(hasUpperCase)
                .test(password);
        System.out.println("Password is " + passwordValid);

    }
}
