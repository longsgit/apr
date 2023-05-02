package com.herbalife.myapi1;

import com.herbalife.model.Car;
import com.herbalife.model.Person;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    public void doSomething() {
        Person person = new Person();
        Car car = new Car();
    }
}
