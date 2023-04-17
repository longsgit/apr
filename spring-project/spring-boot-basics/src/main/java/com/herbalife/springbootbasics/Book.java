package com.herbalife.springbootbasics;

import org.springframework.stereotype.Component;

@Component
public class Book {
    public Book() {
        System.out.println("****Book created");
    }
}
