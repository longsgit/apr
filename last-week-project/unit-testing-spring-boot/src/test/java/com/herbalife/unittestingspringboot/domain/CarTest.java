package com.herbalife.unittestingspringboot.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
//@ActiveProfiles("perf")
public class CarTest {
    @Autowired
    private Car car;

    @Test
    public void checkCarIsNotNull() {
        assertNotNull(car);
    }

    @Test
    public void carModelAndYearHaveProperValues() {
        assertEquals("BMW", car.getModel());
        assertEquals(2020, car.getYear());
    }
}
