package dev.patika.librarymanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookBorrowingUpdateRequest {

    private long id;

    @NotBlank
    private String borrowerName;

    @NotBlank
    private String borrowingDate;

    @NotBlank
    private long bookId;
}
