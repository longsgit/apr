package com.herbalife.springbootrestapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//-Dspring.profiles.active=<profileName>
@RestController
public class SampleController {

    @Value("${welcome}")
    private String welcome;

    @GetMapping("/welcome")
    public String getWelcome() {
        return welcome;
    }
}
