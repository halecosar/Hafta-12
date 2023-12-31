package dev.patika.librarymanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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

    @Column (name= "borrower_mail")
    @Email
    @NotNull
    private String borrowerMail;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_on_date")
    private LocalDate borrowingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrowreturn_date")
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "borrowing_book_id", referencedColumnName = "book_id")
    private Book book;
}
