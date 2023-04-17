package com.herbalife.examples;

import org.springframework.stereotype.Component;

@Component
public class Alarm {
    public void activate() {
        System.out.println("Alarm activated");
    }

    public void deactivate() {
        System.out.println("Alarm deactivated");

    }
}
