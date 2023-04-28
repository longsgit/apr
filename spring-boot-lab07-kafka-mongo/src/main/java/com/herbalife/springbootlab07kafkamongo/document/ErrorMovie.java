package com.herbalife.springbootlab07kafkamongo.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "movies-errors")
public class ErrorMovie {
    @Id
    private String id;
    @Field
    private String title;
    @Field
    private int year;
}
