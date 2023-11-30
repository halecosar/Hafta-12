package dev.patika.librarymanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name ="authors")
@Data
@AllArgsConstructor //parametreli constructor
@NoArgsConstructor //parametresiz constructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", columnDefinition = "serial")
    private Long id;
    @Column(name = "author_name")
    @NotNull
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "author_birthday")

    private LocalDate birthday;
    @Column(name = "author_country")
    private String country;
}
