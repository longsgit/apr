package com.herbalife.jpawithdatarestapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @Column(name = "year")
    private Integer year;

    @Column(name = "language")
    private String language;


}
