package com.herbalife.springbootbasics;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Training {
    public Training() {
        System.out.println("***TRaining created");
    }
}
