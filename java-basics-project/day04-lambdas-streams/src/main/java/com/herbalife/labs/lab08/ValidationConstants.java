package com.herbalife.labs.lab08;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public interface ValidationConstants {
    Predicate<String> isNotBlank = value -> !value.isBlank();
    Predicate<String> isNotEmpty = value -> !value.isEmpty();
    Predicate<String> isNotNull = value -> value != null;

    BiFunction<Integer, Integer, Predicate<String>> lengthValidator =
            (min, max) -> value -> value.length() >= min && value.length() <= max;

//    Predicate<String> userNameLength = value -> value.length() >= 6 && value.length() <= 12;
//    Predicate<String> passwordLength = value -> value.length() >= 8 && value.length() <= 14;

    Predicate<String> hasDigit = value -> value.matches(".*\\d+.*");
    Predicate<String> hasUpperCase = value -> value.matches(".*[A-Z].*");
}
