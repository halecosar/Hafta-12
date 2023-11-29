package dev.patika.librarymanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name= "publishers")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id" , columnDefinition = "serial")
    @NotNull
    private Long id;
    @Column (name = "publisher_name" , unique = true)
    private String name;
    @Column (name= "establish_year")
    private  int establishmentYear;
    @ Column (name= "address")
    private String address;

}
