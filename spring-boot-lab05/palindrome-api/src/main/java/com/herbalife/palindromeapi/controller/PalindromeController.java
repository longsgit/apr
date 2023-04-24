package com.herbalife.palindromeapi.controller;

import com.herbalife.palindromeapi.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {

    @Autowired
    private PalindromeService palindromeService;

    @GetMapping("/palindrome/{word}")
    public boolean checkPalindrome(@PathVariable String word) {
        return palindromeService.isPalindrome(word);
    }
}
