package com.herbalife.myapi1;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Represents the Person entity")
@Data
public class Person {
    @Schema(defaultValue = "Sam")
    private String name;
    @Schema(defaultValue = "10")
    private int age;
}
