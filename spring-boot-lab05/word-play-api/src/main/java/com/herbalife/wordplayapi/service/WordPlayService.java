package com.herbalife.wordplayapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;

import static com.herbalife.wordplayapi.constants.Constants.PALINDROME_API_URL;

@Service
public class WordPlayService {

    @Value("${palindrome-api.host}")
    private String palindromeApiHost;

    @Value("${palindrome-api.port}")
    private int palindromeApiPort;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpClient httpClient;

    public String isPalindrome(String word) {
        String url = PALINDROME_API_URL.formatted(palindromeApiHost, palindromeApiPort, word);
        ResponseEntity<Boolean> booleanResponseEntity = restTemplate.getForEntity(url, Boolean.class);
        boolean result = booleanResponseEntity.getBody();
        if (result) {
            return "%s is a palindrome".formatted(word);
        }
        return "%s is not a palindrome".formatted(word);
    }
}
