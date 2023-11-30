package dev.patika.librarymanagement.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookBorrowingUpdateResponse {
    @NotBlank
    public String borrowerName;

    @NotBlank
    private String borrowingDate;

    @NotBlank
    private long bookId;
}
