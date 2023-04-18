package com.herbalife.springbootbasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bank {
    private String name;
    private HeadOffice headOffice;

    public Bank(@Value("${bank-name}:Chase") String name, HeadOffice headOffice) {
    //public Bank(@Value("Citibank") String name, @Autowired HeadOffice headOffice) {
        this.name = name;
        this.headOffice = headOffice;
    }
}
