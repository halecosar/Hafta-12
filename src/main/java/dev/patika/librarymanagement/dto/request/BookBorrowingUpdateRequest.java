package dev.patika.librarymanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingUpdateRequest {

    private Long id;

    private String borrowerName;

    private long bookId;

    private LocalDate returnDate;
}
