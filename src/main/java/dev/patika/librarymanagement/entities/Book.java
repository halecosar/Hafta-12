package dev.patika.librarymanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany (mappedBy = "book", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<BookBorrowing> borrowerList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_publisher_id", referencedColumnName = "publisher_id")
    private Publisher publisher;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "book_author_id", referencedColumnName = "author_id")
    private Author author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book2cat",
            joinColumns = {@JoinColumn(name = "book2cat_book_id")},
            inverseJoinColumns = {@JoinColumn(name = "book2cat_category_id")}
    )
    private List<Category> categoryList;
}
