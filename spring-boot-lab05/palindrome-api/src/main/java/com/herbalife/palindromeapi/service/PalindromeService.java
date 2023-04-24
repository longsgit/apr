package com.herbalife.palindromeapi.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {

    public boolean isPalindrome(String word) {
        return word
                .equalsIgnoreCase(new StringBuilder(word)
                        .reverse()
                        .toString());
    }
}
