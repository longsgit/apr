package com.herbalife.wordplayapi.controller;

import com.herbalife.wordplayapi.service.WordPlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordPlayController {
    @Autowired
    private WordPlayService wordPlayService;

    @GetMapping("/word/{word}")
    public String checkPalindrome(@PathVariable String word) {
        return wordPlayService.isPalindrome(word);
    }
}
