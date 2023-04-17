package com.herbalife.examples;

import org.springframework.stereotype.Component;

@Component
public class Door {
    public void open() {
        System.out.println("Door is open");
    }

    public void close() {
        System.out.println("Door is closed");
    }

}

