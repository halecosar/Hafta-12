package dev.patika.librarymanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name= "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    @Column(name= "book_id" , columnDefinition = "serial")
    private Long id;

    @Column(name= "book_name")
    @NotNull

    private String bookName;

    @Column (name= "publication_year")
    private int publicationYear;

    @Column (name= "stock")
    @NotNull
    private int stock;

}
