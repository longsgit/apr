package com.herbalife.springbootlab04restapijpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "topics")
@Data
@ToString
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotBlank
    @NotNull
    @Size(min = 2, max = 40)
    private String title;

    @Column
    @Min(45)
    @Max(120)
    private int duration;
}
