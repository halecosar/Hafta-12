package dev.patika.librarymanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name= "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", columnDefinition = "serial")
    @NotNull
    private int id;

    @Column (name = "category_name" , unique = true)
    private String name;

    @Column (name = "category_description")
    private String categoryDescription;

    @ManyToMany(mappedBy = "categoryList")
    private List<Book> bookList;

}
