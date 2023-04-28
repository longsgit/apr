package com.herbalife.jpawithdatarestapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column
    private int duration;
}
