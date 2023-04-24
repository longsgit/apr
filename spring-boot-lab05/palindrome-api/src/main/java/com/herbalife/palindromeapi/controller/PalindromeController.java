package com.herbalife.palindromeapi.controller;

import com.herbalife.palindromeapi.service.PalindromeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Palindrome Controller", description = "Checks if the given word is palindrome")
@RestController
public class PalindromeController {

    @Autowired
    private PalindromeService palindromeService;

    @Operation(description = "checks if the given word is a palindrome")
    @ApiResponse(responseCode = "200", description = "Palindrome check is successful")
    @GetMapping("/palindrome/{word}")
    public boolean checkPalindrome(@PathVariable String word) {
        return palindromeService.isPalindrome(word);
    }
}
