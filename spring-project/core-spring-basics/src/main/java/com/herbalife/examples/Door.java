package com.herbalife.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Door {
    @Autowired
    private Alarm alarm;

    public void open() {
        System.out.println("Door is open");
        alarm.activate();
    }

    public void close() {
        System.out.println("Door is closed");
        alarm.deactivate();
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }
}

