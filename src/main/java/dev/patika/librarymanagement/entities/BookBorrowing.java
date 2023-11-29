package dev.patika.librarymanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table (name= "borrowings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowing_id" , columnDefinition = "serial")
    private Long id;
    @ Column (name= "borrower_name" )
    @NotNull
    private String borrowerName;


    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_on_date")
    @NotNull
    private LocalDate borrowingDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "borrowReturn_date")
    @NotNull
    private LocalDate returnDate;

}
