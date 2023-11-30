package dev.patika.librarymanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingUpdateRequest {

    private int id;

    private String borrowerName;

    private LocalDate borrowingDate;

    private long bookId;
}
